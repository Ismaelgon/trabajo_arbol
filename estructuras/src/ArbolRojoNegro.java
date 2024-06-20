public class ArbolRojoNegro extends ArbolBinario {
    private NodoRojoNegro raiz;

    @Override
    public void agregar(int valor) {
        raiz = agregar(raiz, valor);
        raiz.color = "BLACK";
    }

    private NodoRojoNegro agregar(NodoRojoNegro nodo, int valor) {
        if (nodo == null) {
            return new NodoRojoNegro(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = agregar(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = agregar(nodo.derecho, valor);
        } else {
            return nodo;
        }

        return balancear(nodo);
    }

    @Override
    public void eliminar(int valor) {
        raiz = eliminar(raiz, valor);
    }

    private NodoRojoNegro eliminar(NodoRojoNegro nodo, int valor) {
        // Implementación de eliminación en árbol Rojo-Negro
        return nodo;
    }

    @Override
    public void insertar(int valor, int posicion) {
        // No aplica para árboles Rojo-Negro
    }

    @Override
    public void inorden() {
        inorden(raiz);
    }

    private void inorden(NodoRojoNegro nodo) {
        if (nodo != null) {
            inorden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorden(nodo.derecho);
        }
    }

    @Override
    public void preorden() {
        preorden(raiz);
    }

    private void preorden(NodoRojoNegro nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preorden(nodo.izquierdo);
            preorden(nodo.derecho);
        }
    }

    @Override
    public void postorden() {
        postorden(raiz);
    }

    private void postorden(NodoRojoNegro nodo) {
        if (nodo != null) {
            postorden(nodo.izquierdo);
            postorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    public NodoRojoNegro balancear(NodoRojoNegro nodo) {
        // Implementación de balanceo de nodo en árbol Rojo-Negro
        return nodo;
    }
}
