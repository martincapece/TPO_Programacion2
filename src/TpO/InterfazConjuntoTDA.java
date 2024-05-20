package TpO;

public interface InterfazConjuntoTDA {
	void InicializarConjunto(); // sin precondiciones
	void Agregar(int x); // conjunto inicializado
	int Elegir(); // conjunto inicialiazado y no vacio
	boolean ConjuntoVacio(); // conjunto inicializado
	void Sacar(int x); // conjunto inicializado
	boolean Pertenece(int x); // cola inicializado
}
