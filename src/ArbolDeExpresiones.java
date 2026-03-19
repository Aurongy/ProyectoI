public class ArbolDeExpresiones {

    // Convierte la expresión normal de infija a postfija
    public String convertir(String infija) {

        Pila<Character> pila = new Pila<>();
        String resultado = "";

        for (int i = 0; i < infija.length(); i++) {

            char c = infija.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                resultado += c;
            }

            // Si es un paréntesis de apertura lo guarda
            else if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            }

            // Si es cierre, empieza a sacar de la pila
            else if (c == ')' || c == ']' || c == '}') {

                while (!pila.isEmpty() && !esApertura(pila.top())) {
                    resultado += pila.pop();
                }

                pila.pop();
            }

            else {
                while (!pila.isEmpty() && prioridad(pila.top()) >= prioridad(c)) {
                    resultado += pila.pop();
                }
                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            resultado += pila.pop();
        }

        return resultado;
    }

    // Revisa si son un símbolo de apertura
    private boolean esApertura(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    // Define qué operadores tiene más importancia
    private int prioridad(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        if (op == '√') return 4;
        return 0;
    }

    // Construye el árbol usando la expresión postfija
    public Nodo construir(String postfija) {

        Pila<Nodo> pila = new Pila<>();

        for (int i = 0; i < postfija.length(); i++) {

            char c = postfija.charAt(i);
            Nodo nuevo = new Nodo(String.valueOf(c));

            if (Character.isLetterOrDigit(c)) {
                pila.push(nuevo);
            }
            else if (c == '√') {
                nuevo.derecha = pila.pop();
                pila.push(nuevo);
            }
            else {
                Nodo derecha = pila.pop();
                Nodo izquierda = pila.pop();

                nuevo.izquierda = izquierda;
                nuevo.derecha = derecha;

                pila.push(nuevo);
            }
        }

        return pila.pop();
    }

    // Recorrido en orden (izquierda, raíz, derecha)
    public String inorden(Nodo n) {
        if (n == null) return "";
        return inorden(n.izquierda) + n.valor + " " + inorden(n.derecha);
    }

    // Recorrido preorden (raíz primero)
    public String preorden(Nodo n) {
        if (n == null) return "";
        return n.valor + " " + preorden(n.izquierda) + preorden(n.derecha);
    }

    // Recorrido postorden (raíz al final)
    public String postorden(Nodo n) {
        if (n == null) return "";
        return postorden(n.izquierda) + postorden(n.derecha) + n.valor + " ";
    }
}