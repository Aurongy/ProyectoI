import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GraficaDeInterfaz extends JFrame {

    private JTextField txtExpresion;
    private JTextPane areaResultado;

    public GraficaDeInterfaz() {

        //Configuracion de la ventana
        setTitle("Árbol de Expresiones");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        txtExpresion = new JTextField();
        txtExpresion.setBorder(BorderFactory.createTitledBorder("Ingrese expresión"));

        // Área donde se muestran resultados
        areaResultado = new JTextPane();
        areaResultado.setEditable(false);
        areaResultado.setBackground(new Color(245, 245, 245));

        // Botón para calcular
        JButton boton = new JButton("Calcular");
        boton.setBackground(new Color(52, 152, 219));
        boton.setForeground(Color.WHITE);

        // Botón para salir del programa
        JButton salir = new JButton("Salir");
        salir.setBackground(new Color(231, 76, 60));
        salir.setForeground(Color.WHITE);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(boton);
        panelBotones.add(salir);

        panel.add(txtExpresion, BorderLayout.NORTH);
        panel.add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void calcular() {

        String infija = txtExpresion.getText().replace(" ", "");

        if (!validar(infija)) {
            mostrarTexto("Expresión inválida", Color.RED);
            return;
        }

        Set<Character> variables = new HashSet<>();
        for (char c : infija.toCharArray()) {
            if (Character.isLetter(c)) {
                variables.add(c);
            }
        }

        Map<Character, Double> valores = new HashMap<>();
        for (char v : variables) {
            String input = JOptionPane.showInputDialog("Valor de " + v);
            valores.put(v, Double.parseDouble(input));
        }

        ArbolDeExpresiones arbol = new ArbolDeExpresiones();
        Evaluador evaluador = new Evaluador();

        String postfija = arbol.convertir(infija);
        Nodo raiz = arbol.construir(postfija);

        double valorFinal = evaluador.evaluar(postfija, valores);

        StyledDocument doc = areaResultado.getStyledDocument();
        areaResultado.setText("");

        // TÍTULO
        agregarTexto(doc, "---- RESULTADOS ----\n\n", new Color(44, 62, 80), true);

        agregarTexto(doc, "Postfija: ", new Color(26, 39, 50), true);
        agregarTexto(doc, postfija + "\n", Color.BLACK, false);

        agregarTexto(doc, "Inorden: ", new Color(26, 39, 50), true);
        agregarTexto(doc, arbol.inorden(raiz) + "\n", Color.BLACK, false);

        agregarTexto(doc, "Preorden: ", new Color(26, 39, 50), true);
        agregarTexto(doc, arbol.preorden(raiz) + "\n", Color.BLACK, false);

        agregarTexto(doc, "Postorden: ", new Color(26, 39, 50), true);
        agregarTexto(doc, arbol.postorden(raiz) + "\n\n", Color.BLACK, false);

        agregarTexto(doc, "Resultado final: ", new Color(192, 57, 43), true);
        agregarTexto(doc, String.valueOf(valorFinal), Color.BLACK, false);

        // Mostrar árbol
        DibujoDeArbol ventana = new DibujoDeArbol(raiz);
        ventana.setVisible(true);
    }

    private void agregarTexto(StyledDocument doc, String texto, Color color, boolean negrita) {
        Style estilo = areaResultado.addStyle("estilo", null);
        StyleConstants.setForeground(estilo, color);
        StyleConstants.setBold(estilo, negrita);

        try {
            doc.insertString(doc.getLength(), texto, estilo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarTexto(String texto, Color color) {
        StyledDocument doc = areaResultado.getStyledDocument();
        areaResultado.setText("");
        agregarTexto(doc, texto, color, true);
    }

    private boolean validar(String expr) {
        for (char c : expr.toCharArray()) {
            if (!Character.isLetterOrDigit(c) &&
                    "+-*/^√()[]{}".indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}