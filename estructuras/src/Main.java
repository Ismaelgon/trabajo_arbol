public class Main {
    public static void main(String[] args) {
        // Crear un árbol AVL
        ArbolAVL arbolAVL = new ArbolAVL();

        // Agregar elementos al árbol AVL
        arbolAVL.agregar(50);
        arbolAVL.agregar(30);
        arbolAVL.agregar(70);
        arbolAVL.agregar(20);
        arbolAVL.agregar(40);
        arbolAVL.agregar(60);
        arbolAVL.agregar(80);

        // Mostrar recorridos del árbol AVL
        System.out.println("Recorrido Inorden del Árbol AVL:");
        arbolAVL.inorden();

        System.out.println("\nRecorrido Preorden del Árbol AVL:");
        arbolAVL.preorden();

        System.out.println("\nRecorrido Postorden del Árbol AVL:");
        arbolAVL.postorden();

        // Crear una lista enlazada simple
        ListaEnlazadaSimple listaSimple = new ListaEnlazadaSimple();

        // Agregar elementos a la lista enlazada simple
        listaSimple.agregar(10);
        listaSimple.agregar(20);
        listaSimple.agregar(5);
        listaSimple.agregar(15);

        // Mostrar lista enlazada simple antes de ordenar
        System.out.println("\n\nLista Enlazada Simple antes de ordenar:");
        imprimirLista(listaSimple);

        // Ordenar la lista enlazada simple
        listaSimple.ordenar();

        // Mostrar lista enlazada simple después de ordenar
        System.out.println("Lista Enlazada Simple después de ordenar:");
        imprimirLista(listaSimple);

        // Ejemplo básico de uso de grafo
        Grafo grafo = new Grafo();

        NodoGrafo nodo1 = grafo.agregarNodo(1);
        NodoGrafo nodo2 = grafo.agregarNodo(2);
        NodoGrafo nodo3 = grafo.agregarNodo(3);

        grafo.agregarArista(nodo1, nodo2, 5);
        grafo.agregarArista(nodo1, nodo3, 10);
        grafo.agregarArista(nodo2, nodo3, 7);

        System.out.println("\nNodos del grafo:");
        for (NodoGrafo nodo : grafo.getNodos()) {
            System.out.print(nodo.valor + " ");
        }
    }

    private static void imprimirLista(ListaEnlazadaSimple lista) {
        NodoSimple actual = lista.getCabeza();
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}