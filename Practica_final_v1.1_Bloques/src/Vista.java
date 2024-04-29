import javax.swing.*;
import java.awt.*;


public class Vista extends JFrame {

    private int width = 400;
    private int height = 600;
    private final DrawCanvas canvas;
    public  Modelo modelo;
    public Controlador controlador;

    public Vista(Modelo modelo){
        setTitle("Brick Breaker");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width,height);

        this.modelo = modelo;

        canvas = new DrawCanvas();
        add(canvas);

    }
    public void setControlador(Controlador controlador){
        this.controlador = controlador;
        addKeyListener(controlador);
    }

    class DrawCanvas extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Dibujar la pelota
            g.setColor(Color.RED);
            g.fillOval(modelo.pelotaX, modelo.pelotaY, modelo.pelotaDiametro, modelo.pelotaDiametro);
            //Dibujar la paleta
            g.setColor(Color.BLUE);
            g.fillRect(modelo.paletaX, modelo.paletaY, modelo.paletaWidth, modelo.paletaHeight);
            //Dibujar los ladrillos
            int[][] nivelActual = modelo.getNivelActual();
            if (nivelActual != null) {
                int ladrilloWidth = modelo.ladrilloWidth;
                int ladrilloHeight = modelo.ladrilloHeight;
                int separacion = 5;

                for (int i = 0; i < nivelActual.length; i++) {
                    for (int j = 0; j < nivelActual[i].length; j++) {
                        if (nivelActual[i][j] != 0) {
                            int x =  j * (ladrilloWidth + separacion);
                            int y = i * (ladrilloHeight + separacion);
                            g.setColor(Color.GREEN);
                            g.fillRect(x, y, ladrilloWidth, ladrilloHeight);

                        }
                    }
                }
            }
        }
    }
    public void informarPelotaFueraDeLaPaleta() {
        controlador.pelotaFueraDeLaPaleta();
    }
}