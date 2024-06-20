import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<NodoGrafo> nodos;

    public Grafo() {
        nodos = new ArrayList<>();
    }

    public NodoGrafo agregarNodo(int valor) {
        NodoGrafo nuevoNodo = new NodoGrafo(valor);
        nodos.add(nuevoNodo);
        return nuevoNodo;
    }

    public void agregarArista(NodoGrafo origen, NodoGrafo destino, int peso) {
        // Suponiendo que se está agregando una arista a una estructura de datos
        // que maneja las aristas. Esta implementación solo añade nodos.
    }

    public List<NodoGrafo> getNodos() {
        return nodos;
    }
}