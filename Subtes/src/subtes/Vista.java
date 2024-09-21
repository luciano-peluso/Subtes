package subtes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vista {

    private Modelo m;
    private JFrame frame;
    private JButton adelante, atras;
    private JLabel estacion, combinacion, mensaje;
    private JPanel panel, panelBotones;
    private JPanel panelInfo;

    public Vista(Modelo m) {
        this.m = m;
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(3,3));
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2));
        
        m.setEstacionesDefault();
        
        mensaje = new JLabel(m.getBienvenida());
        estacion = new JLabel(m.getEstacion());
        combinacion = new JLabel(m.getCombinacion());
        
        adelante = new JButton(m.getBotonAdelante());
        atras = new JButton(m.getBotonAtras());
        
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        estacion.setHorizontalAlignment(SwingConstants.CENTER);
        combinacion.setHorizontalAlignment(SwingConstants.CENTER);
    
        panelInfo.add(mensaje, BorderLayout.NORTH);
        panelInfo.add(estacion, BorderLayout.CENTER);
        panelInfo.add(combinacion, BorderLayout.SOUTH);
        
        panelBotones.add(atras);
        panelBotones.add(adelante);
        
        panel.add(panelInfo, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);
        
        frame.add(panel, BorderLayout.CENTER);
    }

    public void mostrarVistaDefault() {
        
        frame.setTitle(m.getTituloApp());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 200);
        //frame.pack();
        frame.setVisible(true);
    }
    
    public void actualizarVista(){
        estacion.setText(m.getEstacion());
        mostrarCombinacion();
    }
    
    public void mostrarCombinacion(){
        m.chequearCombinacion();
        combinacion.setText(m.getCombinacion());
    }

    public void agregarActionListenerAdelante(ActionListener al) {
        adelante.addActionListener(al);
    }

    public void agregarActionListenerAtras(ActionListener al) {
        atras.addActionListener(al);
    }
}
