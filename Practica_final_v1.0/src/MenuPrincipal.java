
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {
    private JPanel ContentPanel;
    private JPanel botonPanel;
    private JButton botonInicio, botonSalir, botonConfiguracion, botonRanking;
    private int width = 400;
    private int height = 600;
    private Modelo modelo;
    public MenuPrincipal() {
        setTitle("Brick Breaker");
        setSize(width, height);
        setBackground(Color.BLACK);
        ContentPanel = new JPanel(new BorderLayout());
        botonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        botonPanel.setLayout(new BoxLayout(botonPanel, BoxLayout.Y_AXIS));
        botonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        botonInicio = new JButton("Jugar");
        botonInicio.setBorder(new EmptyBorder(10,10,10,10));

        botonInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });
        botonPanel.add(botonInicio, 10, 0);

        botonConfiguracion = new JButton("Configuracion");
        botonConfiguracion.setBorder(new EmptyBorder(10,10,10,10));
        botonPanel.add(botonConfiguracion, 10, 1);
        botonConfiguracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // menuConfiguracion menuConfiguracion = new menuConfiguracion();
            }
        });
        botonSalir = new JButton("Salir");
        botonSalir.setBorder(new EmptyBorder(10,10,10,10));

        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        botonPanel.add(botonSalir, 10, 2);

        ContentPanel.add(botonPanel,BorderLayout.SOUTH);
        add(ContentPanel);
        setVisible(true);
        modelo = new Modelo();
    }
    private void iniciarJuego(){
        Vista vista = new Vista(modelo);
        Controlador controlador = new Controlador(modelo,vista);
        vista.setControlador(controlador);
        vista.setVisible(true);
        this.setVisible(false);
    }

}
