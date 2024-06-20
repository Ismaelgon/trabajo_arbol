public class ListaEnlazadaSimple {
    private NodoSimple cabeza;

    public ListaEnlazadaSimple() {
        this.cabeza = null;
    }

    public void agregar(int valor) {
        NodoSimple nuevo = new NodoSimple(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public NodoSimple getCabeza() {
        return cabeza;
    }

    public void ordenar() {
        if (cabeza == null) return;

        NodoSimple actual = cabeza;
        while (actual != null) {
            NodoSimple index = actual.siguiente;
            while (index != null) {
                if (actual.valor > index.valor) {
                    int temp = actual.valor;
                    actual.valor = index.valor;
                    index.valor = temp;
                }
                index = index.siguiente;
            }
            actual = actual.siguiente;
        }
    }
}