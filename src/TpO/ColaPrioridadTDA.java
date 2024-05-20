package TpO;

public class ColaPrioridadTDA implements InterfazColaTDAPrioridad {
	
	// Creamos una subclase "Elemento" para definir que tipo de elementos almacenara la cola
	class Elemento {
		int valor;
		int prioridad;
	}
	
	// Definimos el arreglo de la cola "elementos" la cual almacenara elementos de tipo "Elemento" y el indice como integro
	Elemento [] elementos;
	int indice;
	
	// Creamos la constructora de la cola para inicializarla en el momento que la instanciemos
	public ColaPrioridadTDA() {
		InicializarCola();
	}
	
	// Creamos este metodo para inicializar los atributos de la cola
	public void InicializarCola() {
		elementos = new Elemento[100];
		indice = 0;
	}

	// Creamos este metodo para poder corroborar el estado actual de la cola (si esta vacia o no)
	public boolean ColaVacia() {
		// Nos devolvera TRUE o FALSE comparando su indice a 0
		return (indice == 0);
	}

	// Creamos este metodo para acolar elementos con sus prioridades especificadas
	public void AcolarPrioridad(int x, int prioridad) {
		// Inicializamos la variable "j" con el numero de elementos que tenga la cola
		int j = indice;
		
		// Este bucle se ejecutara solo si la prioridad del ultimo elemento de la cola es mayor a la del nuevo elemento que se quiere ingresar
		// Si esto sucede, el elemento con prioridad mas grande pasara a ocupar la posicion a la que apunta el indice y el nuevo elemento se colara una vez que no haya prioridad mayor o igual a la suya.
		// Ej: Si se ingresa un elemento de prioridad "1" se colocara al principio de la cola. Y si hay uno de prioridad 3 es muy probable que vaya en las posiciones finales.
		for (; j > 0 && elementos[ j - 1 ].prioridad >= prioridad; j--) {
			elementos[j] = elementos[j-1];
		}
		
		// Una vez que ya no se ejecutara mas el bucle, vamos a posicionarnos en una posicion antigua del elemento desplzado (esta posicion "antigua" ya tomo una nueva donde le correspondia)
		// Entonces el nuevo elemento sera colocado en la posicion antigua del elemento que fue trasladado a su lugar correspondiente.
		elementos[j] = new Elemento();
		elementos[j].valor = x;
		elementos[j].prioridad = prioridad;
		
		// Incrementamos el numero de elementos dentro de la cola
		indice ++;
	}

	// Creamos este metodo para desacolar el elemento con prioridad mas alta
	public void Desacolar() {
		// De esta manera vamos a colocar un null (vacio) en la ultima posicion de la cola
		elementos[indice - 1] = null;
		
		// Decrementamos en 1 la cantidad de elementos de la cola
		indice --;
	}

	// Creamos este metodo para recuperar la prioridad del elemento en la ultima posicion de la cola
	public int Prioridad() {
		return elementos[indice - 1].prioridad;
	}

	// Creamos este metodo para recuperar el ultimo elemento de la cola
	public int Primero() {
		return elementos[indice - 1].valor;
	}
	
}
