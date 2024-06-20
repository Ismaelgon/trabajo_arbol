public class NodoDobleCircular {
    int valor;
    NodoDobleCircular siguiente;
    NodoDobleCircular anterior;

    public NodoDobleCircular(int valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }
}
