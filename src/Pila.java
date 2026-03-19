import java.util.ArrayList;

public class Pila<T> {

    private ArrayList<T> datos;

    public Pila() {
        datos = new ArrayList<>();
    }

    public void push(T dato) {
        datos.add(dato);
    }

    public T pop() {
        if (datos.isEmpty()) {
            return null;
        }
        return datos.remove(datos.size() - 1);
    }

    public T top() {
        if (datos.isEmpty()) {
            return null;
        }
        return datos.get(datos.size() - 1);
    }

    public boolean isEmpty() {
        return datos.isEmpty();
    }
}