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

    class DrawCanvas extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //Dibujar la pelota
            g.setColor(Color.RED);
            g.fillOval(modelo.pelotaX,modelo.pelotaY , modelo.pelotaDiametro, modelo.pelotaDiametro);
            //Dibujar la paleta
            g.setColor(Color.BLUE);
            g.fillRect(modelo.paletaX, modelo.paletaY, modelo.paletaWidth, modelo.paletaHeight);
            //Dibujar los ladrillos
            g.setColor(Color.GREEN);

        }
    }
    public void informarPelotaFueraDeLaPaleta() {
        controlador.pelotaFueraDeLaPaleta();
    }
}
