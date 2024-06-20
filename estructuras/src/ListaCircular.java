public class ListaCircular {
    private NodoCircular cabeza;

    public void agregar(int valor) {
        NodoCircular nuevoNodo = new NodoCircular(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
        } else {
            NodoCircular temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        }
    }

    public void eliminar(int valor) {
        if (cabeza == null) return;
        if (cabeza.valor == valor) {
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
            } else {
                NodoCircular temp = cabeza;
                while (temp.siguiente != cabeza) {
                    temp = temp.siguiente;
                }
                temp.siguiente = cabeza.siguiente;
                cabeza = cabeza.siguiente;
            }
            return;
        }
        NodoCircular actual = cabeza;
        do {
            if (actual.siguiente.valor == valor) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void insertar(int valor, int posicion) {
        NodoCircular nuevoNodo = new NodoCircular(valor);
        if (posicion == 0) {
            if (cabeza == null) {
                cabeza = nuevoNodo;
                cabeza.siguiente = cabeza;
            } else {
                NodoCircular temp = cabeza;
                while (temp.siguiente != cabeza) {
                    temp = temp.siguiente;
                }
                nuevoNodo.siguiente = cabeza;
                cabeza = nuevoNodo;
                temp.siguiente = cabeza;
            }
            return;
        }
        NodoCircular temp = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            if (temp.siguiente == cabeza) break;
            temp = temp.siguiente;
        }
        nuevoNodo.siguiente = temp.siguiente;
        temp.siguiente = nuevoNodo;
    }

    public void ordenar() {
        if (cabeza == null || cabeza.siguiente == cabeza) return;
        cabeza = mergeSort(cabeza);
        NodoCircular temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = cabeza;
    }

    private NodoCircular mergeSort(NodoCircular h) {
        if (h == null || h.siguiente == h) {
            return h;
        }
        NodoCircular medio = getMedio(h);
        NodoCircular siguienteMedio = medio.siguiente;
        medio.siguiente = null;
        NodoCircular izquierda = mergeSort(h);
        NodoCircular derecha = mergeSort(siguienteMedio);
        return merge(izquierda, derecha);
    }

    private NodoCircular getMedio(NodoCircular h) {
        if (h == null) return h;
        NodoCircular rapido = h.siguiente;
        NodoCircular lento = h;
        while (rapido != null && rapido.siguiente != h) {
            rapido = rapido.siguiente.siguiente;
            if (rapido != null && rapido != h) {
                lento = lento.siguiente;
            }
        }
        return lento;
    }

    private NodoCircular merge(NodoCircular izquierda, NodoCircular derecha) {
        NodoCircular resultado = null;
        if (izquierda == null) return derecha;
        if (derecha == null) return izquierda;
        if (izquierda.valor <= derecha.valor) {
            resultado = izquierda;
            resultado.siguiente = merge(izquierda.siguiente, derecha);
        } else {
            resultado = derecha;
            resultado.siguiente = merge(izquierda, derecha.siguiente);
        }
        return resultado;
    }
}
