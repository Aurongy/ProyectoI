public class Nodo {

    // Aquí guardamos el valor del nodo
    String valor;

    // Referencias a los hijos izquierdo y derecho
    Nodo izquierda;
    Nodo derecha;

    public Nodo(String valor) {
        this.valor = valor;

        // Al inicio si no tiene hijos
        this.izquierda = null;
        this.derecha = null;
    }
}