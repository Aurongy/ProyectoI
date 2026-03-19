import javax.swing.*;
import java.awt.*;

public class DibujoDeArbol extends JFrame {

    private Nodo nodo;

    public DibujoDeArbol(Nodo nodo) {
        this.nodo = nodo;
        configurarInterfaz();
    }

    private void configurarInterfaz() {

        setTitle("Árbol de Expresiones");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Panel donde se va a dibujar el arbol
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujar(g, nodo, getWidth() / 2, 60, 200);
            }
        };

        panel.setBackground(new Color(245, 245, 245)); // fondo suave
        add(panel);
    }

    //Este metodo lo que hace es que dibuja cada nodo
    private void dibujar(Graphics g, Nodo nodo, int x, int y, int espacio) {

        if (nodo == null) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        int nuevoEspacio = espacio / 2;

        //Dibueja los hijos izquierdos
        if (nodo.izquierda != null) {
            g2.setColor(Color.GRAY);
            g2.drawLine(x, y, x - espacio, y + 80);
            dibujar(g2, nodo.izquierda, x - espacio, y + 80, nuevoEspacio);
        }

        //Dibuja los hijos derechos
        if (nodo.derecha != null) {
            g2.setColor(Color.GRAY);
            g2.drawLine(x, y, x + espacio, y + 80);
            dibujar(g2, nodo.derecha, x + espacio, y + 80, nuevoEspacio);
        }

        if ("+-*/^√".contains(nodo.valor)) {
            g2.setColor(new Color(52, 152, 219)); // azul operadores
        } else {
            g2.setColor(new Color(46, 204, 113)); // verde valores
        }

        //Dibuja el circulo del nodo
        g2.fillOval(x - 20, y - 20, 40, 40);
        g2.setColor(Color.BLACK);
        g2.drawOval(x - 20, y - 20, 40, 40);

        //Escribe el valor
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 14));

        FontMetrics fm = g2.getFontMetrics();
        int ancho = fm.stringWidth(nodo.valor);

        g2.drawString(nodo.valor, x - ancho / 2, y + 5);
    }
}