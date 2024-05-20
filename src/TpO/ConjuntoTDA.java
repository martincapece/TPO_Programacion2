package TpO;

public class ConjuntoTDA implements InterfazConjuntoTDA{
	
	// Definimos los atributos que tendran los conjuntos instanciados
	int [] a;
	int cant;
	
	// Creamos la constructora del conjunto para inicializarlo en el momento que lo instanciemos
	public ConjuntoTDA() {
		InicializarConjunto();
	}
	
	// Creamos este metodo para inicializar los atributos del conjunto
	public void InicializarConjunto() {
		a = new int[100];
		cant = 0;
	}
	
	// Creamos este metodo para poder añadir elementos al conjunto
	public void Agregar(int x) {
		// Utilizamos el IF para corroborar que el elemento no este repetido dentro del conjunto
		if (!this.Pertenece(x)) {
			a[cant] = x;
			cant ++;
		}
	}
	
	// Creamos este metodo para poder recuperar el elemento de la ultima posicion del conjunto
	public int Elegir() {
		return a[cant - 1];
	}

	// Creamos este metodo para poder corroborar el estado actual del conjunto (si esta vacio o no)
	public boolean ConjuntoVacio() {
		// Nos devolvera TRUE o FALSE dependiendo de la cantidad comparandola a 0
		return (cant == 0);
	}

	// Creamos este metodo para poder sacar un elemento del conjunto
	public void Sacar(int x) {
		// Inicializamos una variable integra "i"
		int i = 0;
		
		// Buscamos dentro del conjunto si esta "x" (El integro a sacar) y tomamos su posicion
		while (i < cant && a[i] != x) {
			i++;
		}
		
		// Chequeamos que el numero haya sido encontrado (de lo contrario "i" seria IGUAL a cant, ya que llegariamos al final de la lista) y lo eliminamos 
		if (i < cant) {
			// Para eliminarlo vamos a suplantar su posicion por el elemento del conjunto en la ultima posicion del conjunto y decrementaremos la cantidad de elementos
			a[i] = a[cant - 1];
			cant--;
		}
	}

	// Creamos este metodo para saber si un elemento pertenece al conjunto utilizando el mismo procedimiento que cuando sacamos un elemento, pero devolviendo un valor booleanao
	public boolean Pertenece(int x) {
		int i = 0;
		while (i<cant && a[i] != x) {
			i ++;
		}
		return (i < cant);
	}

	
}
