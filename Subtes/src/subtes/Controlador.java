/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subtes;

import java.awt.event.*;

/**
 *
 * @author SirLucho
 */
public class Controlador {

    private Modelo m;
    private Vista v;

    public Controlador(Modelo m, Vista v) {
        this.m = m;
        this.v = v;
    }

    public void ejecutar() {
        v.mostrarVistaDefault();
        v.agregarActionListenerAdelante(new ListenerAdelante());
        v.agregarActionListenerAtras(new ListenerAtras());
    }

    private class ListenerAdelante implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            m.adelante();
            v.actualizarVista();
        }
    }

    private class ListenerAtras implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            m.atras();
            v.actualizarVista();
        }
    }
}
