public class ListaDoblementeCircular {
    private NodoDobleCircular cabeza;

    public void agregar(int valor) {
        NodoDobleCircular nuevoNodo = new NodoDobleCircular(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoDobleCircular temp = cabeza.anterior;
            temp.siguiente = nuevoNodo;
            nuevoNodo.anterior = temp;
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
        }
    }

    public void eliminar(int valor) {
        if (cabeza == null) return;
        if (cabeza.valor == valor) {
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
            } else {
                NodoDobleCircular temp = cabeza.anterior;
                temp.siguiente = cabeza.siguiente;
                cabeza.siguiente.anterior = temp;
                cabeza = cabeza.siguiente;
            }
            return;
        }
        NodoDobleCircular actual = cabeza;
        do {
            if (actual.valor == valor) {
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void insertar(int valor, int posicion) {
        NodoDobleCircular nuevoNodo = new NodoDobleCircular(valor);
        if (posicion == 0) {
            if (cabeza == null) {
                cabeza = nuevoNodo;
                cabeza.siguiente = cabeza;
                cabeza.anterior = cabeza;
            } else {
                NodoDobleCircular temp = cabeza.anterior;
                nuevoNodo.siguiente = cabeza;
                nuevoNodo.anterior = temp;
                cabeza.anterior = nuevoNodo;
                temp.siguiente = nuevoNodo;
                cabeza = nuevoNodo;
            }
            return;
        }
        NodoDobleCircular temp = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            if (temp.siguiente == cabeza) break;
            temp = temp.siguiente;
        }
        nuevoNodo.siguiente = temp.siguiente;
        nuevoNodo.anterior = temp;
        temp.siguiente.anterior = nuevoNodo;
        temp.siguiente = nuevoNodo;
    }

    public void ordenar() {
        if (cabeza == null || cabeza.siguiente == cabeza) return;
        cabeza = mergeSort(cabeza);
        NodoDobleCircular temp = cabeza;
        while (temp.siguiente != cabeza) {
            temp = temp.siguiente;
        }
        temp.siguiente = cabeza;
        cabeza.anterior = temp;
    }

    private NodoDobleCircular mergeSort(NodoDobleCircular h) {
        if (h == null || h.siguiente == h) {
            return h;
        }
        NodoDobleCircular medio = getMedio(h);
        NodoDobleCircular siguienteMedio = medio.siguiente;
        medio.siguiente = null;
        NodoDobleCircular izquierda = mergeSort(h);
        NodoDobleCircular derecha = mergeSort(siguienteMedio);
        return merge(izquierda, derecha);
    }

    private NodoDobleCircular getMedio(NodoDobleCircular h) {
        if (h == null) return h;
        NodoDobleCircular rapido = h.siguiente;
        NodoDobleCircular lento = h;
        while (rapido != null && rapido.siguiente != h) {
            rapido = rapido.siguiente.siguiente;
            if (rapido != null && rapido != h) {
                lento = lento.siguiente;
            }
        }
        return lento;
    }

    private NodoDobleCircular merge(NodoDobleCircular izquierda, NodoDobleCircular derecha) {
        NodoDobleCircular resultado = null;
        if (izquierda == null) return derecha;
        if (derecha == null) return izquierda;
        if (izquierda.valor <= derecha.valor) {
            resultado = izquierda;
            resultado.siguiente = merge(izquierda.siguiente, derecha);
            if (resultado.siguiente != null) {
                resultado.siguiente.anterior = resultado;
            }
        } else {
            resultado = derecha;
            resultado.siguiente = merge(izquierda, derecha.siguiente);
            if (resultado.siguiente != null) {
                resultado.siguiente.anterior = resultado;
            }
        }
        return resultado;
    }
}
