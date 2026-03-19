import java.util.Map;
import java.util.Stack;

public class Evaluador {

    // Evalúa la expresión postfija ya con valores
    public double evaluar(String postfija, Map<Character, Double> valores) {

        Stack<Double> pila = new Stack<>();

        for (int i = 0; i < postfija.length(); i++) {

            char c = postfija.charAt(i);

            // Si es número lo convierte y lo mete a la pila
            if (Character.isDigit(c)) {
                pila.push((double)(c - '0'));
            }
            // Si es letra usa el valor ingresado por el usuario
            else if (Character.isLetter(c)) {
                pila.push(valores.get(c));
            }
            else if (c == '√') {
                double a = pila.pop();
                pila.push(Math.sqrt(a));
            }
            // Todos las operaciones
            else {
                double b = pila.pop();
                double a = pila.pop();

                if (c == '+') pila.push(a + b);
                else if (c == '-') pila.push(a - b);
                else if (c == '*') pila.push(a * b);
                else if (c == '/') pila.push(a / b);
                else if (c == '^') pila.push(Math.pow(a, b));
            }
        }

        return pila.pop();
    }
}