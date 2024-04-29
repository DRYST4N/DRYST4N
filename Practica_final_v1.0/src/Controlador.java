
import javax.swing.Timer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Controlador extends KeyAdapter {
    private Modelo modelo;
    private Vista vista;
    private Timer timer;



    public Controlador(Modelo modelo, Vista vista){
        this.modelo = modelo;
        this.vista = vista;
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverPelota();
            }
        });
        timer.start();
    }
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                movimientoPaletaIzq();
                break;
            case KeyEvent.VK_RIGHT:
                movimientoPaletaDer();
                break;
        }
    }
    void movimientoPaletaIzq(){
        modelo.paletaX -= 10; // Mover la paleta hacia la izquierda
        if(modelo.paletaX < 0){
            modelo.paletaX = 0;
        }
        vista.repaint();
    }
    void movimientoPaletaDer(){
        modelo.paletaX += 10; // Mover la paleta hacia la derecha
        if(modelo.paletaX + modelo.paletaWidth > vista.getWidth()){ // Limitar la barra dentro del panel
            modelo.paletaX = vista.getWidth() - modelo.paletaWidth;
        }
        vista.repaint();
    }
    void moverPelota(){
        modelo.pelotaX += modelo.velocidadPelota_dx;
        modelo.pelotaY += modelo.velocidadPelota_dy;

        // Revertir la dirección si la pelota toca los límites del área de juego
        if (modelo.pelotaX <= 0 || modelo.pelotaX >= vista.getWidth() - modelo.pelotaDiametro) {
            modelo.velocidadPelota_dx = -modelo.velocidadPelota_dx;
        }
        if (modelo.pelotaY <= 0 || modelo.pelotaY >= vista.getHeight() - modelo.pelotaDiametro) {
            modelo.velocidadPelota_dy = -modelo.velocidadPelota_dy;
        }
        if (modelo.pelotaY + modelo.pelotaDiametro >= modelo.paletaY &&
                modelo.pelotaY <= modelo.paletaY + modelo.paletaHeight &&
                modelo.pelotaX + modelo.pelotaDiametro >= modelo.paletaX &&
                modelo.pelotaX <= modelo.paletaX + modelo.paletaWidth) {
            modelo.velocidadPelota_dy = -modelo.velocidadPelota_dy; // Invertir la dirección en Y
        }
        if (modelo.pelotaY >= modelo.paletaY + modelo.paletaHeight) {
            // Si la pelota está por debajo de la posición de la paleta, volver al menú principal
            vista.informarPelotaFueraDeLaPaleta();
        }

        vista.repaint();
    }
    public void pelotaFueraDeLaPaleta() {
        modelo = new Modelo(); // Reiniciar el modelo
        vista.dispose(); // Cerrar la ventana de juego
        timer.stop();
        MenuPrincipal menu = new MenuPrincipal(); // Volver al menú principal

    }

}

