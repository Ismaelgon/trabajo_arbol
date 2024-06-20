public class NodoRojoNegro {
    int valor;
    NodoRojoNegro izquierdo;
    NodoRojoNegro derecho;
    String color;

    public NodoRojoNegro(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.color = "RED";
    }
}
