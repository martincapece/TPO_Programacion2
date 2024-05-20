package TpO;

public interface InterfazColaTDAPrioridad {
	void InicializarCola(); // sin precondiciones
	boolean ColaVacia(); // cola inicializada
	void Desacolar(); // cola inicializada
	int Prioridad(); // cola inicialiazada y no vacia
	int Primero(); // cola inicializada y no vacia
	void AcolarPrioridad(int x, int prioridad); // cola inicializada y no vacia
}
