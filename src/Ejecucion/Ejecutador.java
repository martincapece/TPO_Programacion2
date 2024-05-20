package Ejecucion;

import TpO.*;
import java.util.Scanner;

public class Ejecutador {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// Instanciamos todas las clases abstractas tanto de la cola para alamacenar todos los clientes, como de los conjuntos para ordernalos por sus prioridades
		ColaPrioridadTDA colaPrioridades = new ColaPrioridadTDA();
		ConjuntoTDA conjuntoEmpresa = new ConjuntoTDA();
        ConjuntoTDA conjuntoParticularCliente = new ConjuntoTDA();
        ConjuntoTDA conjuntoParticularNoCliente = new ConjuntoTDA();
        
        // Vamos a utilizar una estrategia para definir cuantos clientes seran atendidos (con un minimo de 15)
        System.out.print("Definir la cantidad de clientes (Minimo de 15): ");
        int cantidadClientes = sc.nextInt();
        
        // En caso de que se defina un numero menor a 15, vamos a entrar en un bucle hasta que el numero sea igual o supere esa cifra
        while (cantidadClientes < 15) {
        	System.out.println("Debe ingresar una cantidad mayor o igual a 15 clientes");
        	System.out.print("Definir la cantidad de clientes (Minimo de 15): ");
        	cantidadClientes = sc.nextInt();
        }
        
        // Definimos un ciclo for para especificar los datos (DNI y TIPO) del total de numero de clientes definido anteriormente 
        for (int i = 1; i <= cantidadClientes; i++) {
        	
        	// Definimos una entrada para el DNI
        	System.out.print("Ingresar DNI del cliente: ");
        	int dni = sc.nextInt();
        	
        	// Definimos una entrada para el TIPO
        	System.out.print("Ingresar TIPO de cliente (1, 2 o 3): ");
    		int cliente = sc.nextInt();
    		
    		// Luego de tener ambas, vamos a llamar al metodo "AcolarPrioridad" de colaPrioridades para ingresar al nuevo cliente a la cola
    		colaPrioridades.AcolarPrioridad(dni, cliente);
    		
    		// Le avisamos al usuario que el cliente fue ingresado con exito a la cola
    		System.out.println("El cliente fue ingresado correctamente a la cola");
    		System.out.println();
        }
        
        // Utilizamos este bucle para organizar y agrupar a los clientes de la cola principal segun su tipo de prioridades
        while (!colaPrioridades.ColaVacia()) {
        	// Con el switch, en base a una condicion (el resultado de "colaPrioridades.Prioridad()"), vamos a añadir al cliente al conjunto que le corresponda
        	switch (colaPrioridades.Prioridad()) {
        	case 1:
        		// Agregamos al ciente al conjunto de clientes de tipo "EMPRESA"
        		conjuntoEmpresa.Agregar(colaPrioridades.Primero());
        		break;
        	case 2:
        		// Agregamos al ciente al conjunto de clientes de tipo "PARTICULAR CLIENTE"
        		conjuntoParticularCliente.Agregar(colaPrioridades.Primero());
        		break;
        	case 3:
        		// Agregamos al ciente al conjunto de clientes de tipo "PARTICULAR NO CLIENTE"
        		conjuntoParticularNoCliente.Agregar(colaPrioridades.Primero());
        		break;
        	}
        	// Desacolamos al cliente previamente acomodado en su conjunto correspondiente para poder recuperar al siguiente cliente dentro de la cola
        	colaPrioridades.Desacolar();
        }
		
        System.out.println("Conjunto clientes de empresa:");
        // Utilizamos un bucle para imprimir el contenido del conjunto de los cliente de tipo "EMPRESA"
        while (!conjuntoEmpresa.ConjuntoVacio()) {
        	// Almacenamos el DNI de un cliente del conjunto en la variable "x"
        	int x = conjuntoEmpresa.Elegir();
        	
        	// Imprimimos el DNI de ese cliente
        	System.out.println(x);
        	
        	// Eliminamos al cliente del conjunto para poder recuperar al siguiente
        	conjuntoEmpresa.Sacar(x);
        }
        
        System.out.println();
        
        System.out.println("Conjunto particulares clientes:");
        // Utilizamos un bucle para imprimir el contenido del conjunto de los cliente de tipo "PARTICULAR CLIENTE"
		while (!conjuntoParticularCliente.ConjuntoVacio()) {
			// Almacenamos el DNI de un cliente del conjunto en la variable "x"
			int x = conjuntoParticularCliente.Elegir();
        	
			// Imprimimos el DNI de ese cliente
			System.out.println(x);
			
			// Eliminamos al cliente del conjunto para poder recuperar al siguiente
        	conjuntoParticularCliente.Sacar(x);
		}
		
		System.out.println();
		
		System.out.println("Conjunto particulares NO clientes:");
		// Utilizamos un bucle para imprimir el contenido del conjunto de los cliente de tipo "PARTICULAR NO CLIENTE"
		while (!conjuntoParticularNoCliente.ConjuntoVacio()) {
			// Almacenamos el DNI de un cliente del conjunto en la variable "x"
			int x = conjuntoParticularNoCliente.Elegir();
        	
			// Imprimimos el DNI de ese cliente
			System.out.println(x);
			
			// Eliminamos al cliente del conjunto para poder recuperar al siguiente
        	conjuntoParticularNoCliente.Sacar(x);
		}
        
	}

}
