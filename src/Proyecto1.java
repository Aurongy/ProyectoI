import javax.swing.SwingUtilities;

public class Proyecto1{
    public static void main(String[] args) {

        // Esto sirve para iniciar la interfaz gráfica de forma correcta
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                // Aquí se crea la ventana principal de nuestro programa
                new GraficaDeInterfaz().setVisible(true);
            }
        });
    }
}