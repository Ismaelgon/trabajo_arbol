public class ListaDoblementeEnlazada {
    private NodoDoble cabeza;

    public void agregar(int valor) {
        NodoDoble nuevoNodo = new NodoDoble(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoDoble temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.anterior = temp;
        }
    }

    public void eliminar(int valor) {
        if (cabeza == null) return;
        if (cabeza.valor == valor) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            }
            return;
        }
        NodoDoble temp = cabeza;
        while (temp != null && temp.valor != valor) {
            temp = temp.siguiente;
        }
        if (temp != null) {
            if (temp.siguiente != null) {
                temp.siguiente.anterior = temp.anterior;
            }
            if (temp.anterior != null) {
                temp.anterior.siguiente = temp.siguiente;
            }
        }
    }

    public void insertar(int valor, int posicion) {
        NodoDoble nuevoNodo = new NodoDoble(valor);
        if (posicion == 0) {
            nuevoNodo.siguiente = cabeza;
            if (cabeza != null) {
                cabeza.anterior = nuevoNodo;
            }
            cabeza = nuevoNodo;
            return;
        }
        NodoDoble temp = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            if (temp.siguiente == null) break;
            temp = temp.siguiente;
        }
        nuevoNodo.siguiente = temp.siguiente;
        if (temp.siguiente != null) {
            temp.siguiente.anterior = nuevoNodo;
        }
        temp.siguiente = nuevoNodo;
        nuevoNodo.anterior = temp;
    }

    public void ordenar() {
        if (cabeza == null || cabeza.siguiente == null) return;
        cabeza = mergeSort(cabeza);
    }

    private NodoDoble mergeSort(NodoDoble h) {
        if (h == null || h.siguiente == null) {
            return h;
        }
        NodoDoble medio = getMedio(h);
        NodoDoble siguienteMedio = medio.siguiente;
        medio.siguiente = null;
        NodoDoble izquierda = mergeSort(h);
        NodoDoble derecha = mergeSort(siguienteMedio);
        return merge(izquierda, derecha);
    }

    private NodoDoble getMedio(NodoDoble h) {
        if (h == null) return h;
        NodoDoble rapido = h.siguiente;
        NodoDoble lento = h;
        while (rapido != null && rapido.siguiente != null) {
            rapido = rapido.siguiente.siguiente;
            lento = lento.siguiente;
        }
        return lento;
    }

    private NodoDoble merge(NodoDoble izquierda, NodoDoble derecha) {
        NodoDoble resultado = null;
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
