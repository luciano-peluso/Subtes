/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subtes;

import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author SirLucho
 */
public class Modelo {

    private String tituloApp;
    private String bdd;
    private String tablaBDD;
    private String driver;
    private String ip;
    private String prefijo;
    private String user;
    private String pswd;
    private String campoEstacion;
    private String campoSiguienteEstacion;
    private Connection conexion;
    private ActionListener listener;
    private String botonAdelante;
    private String botonAtras;
    private String bienvenida;
    private String estacion;
    private String combinacion;
    
    private final int PRIMERA_COLUMNA;
    private final int SEGUNDA_COLUMNA;
    private final int TERCERA_COLUMNA;

    public Modelo() {
        PRIMERA_COLUMNA = 1;
        SEGUNDA_COLUMNA = 2;
        TERCERA_COLUMNA = 3;
        bdd = "subte";
        tablaBDD = "estaciones";
        campoEstacion = "estacion";
        campoSiguienteEstacion = "estacion_siguiente";
        user = "root";
        pswd = "";
        driver = "com.mysql.cj.jdbc.Driver";
        prefijo = "jdbc:mysql://";
        ip = "127.0.0.1";

        tituloApp = "Subterraneo Linea B";
        botonAdelante = "Adelante >>";
        botonAtras = "<< Atras";
        bienvenida = "Usted se encuentra en la estacion: ";
        estacion = "";
    }
    
    public void setEstacionesDefault(){
        // TRAE LA PRIMERA ESTACION DE TODAS, EN ESTE CASO ROSAS POR SER TERMINAL
        String query = "SELECT * FROM `"+ tablaBDD +"` LIMIT 1;";
        conexion = obtenerConexion();
        
        try{
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                estacion = resultSet.getString(PRIMERA_COLUMNA);
                if(resultSet.getString(TERCERA_COLUMNA) != null){
                    combinacion = resultSet.getString(TERCERA_COLUMNA);
                }else{
                    System.out.println("La estacion no tiene combinaciones");
                }
            }
            System.out.println("Se seteo la vista por primera vez");
            resultSet.close();
            statement.close();
        }catch(SQLException ex){
            reportException(ex.getMessage());
        }
    }
    
    public void chequearCombinacion(){
        String query = "SELECT * FROM `"+tablaBDD+"` WHERE `"+campoEstacion+"` = '"+estacion+"';";
        conexion = obtenerConexion();
        
        try{
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                if(resultSet.getString(TERCERA_COLUMNA) != null){
                    combinacion = "La estacion combina con la/s linea/s: "+resultSet.getString(TERCERA_COLUMNA);
                }else{
                    combinacion = "";
                }
            }
            resultSet.close();
            statement.close();
        }catch(SQLException ex){
            reportException(ex.getMessage());
        }
    }
    
    public void adelante(){
        System.out.println("Adelante");
        String query = "SELECT * FROM `"+tablaBDD+"` WHERE `"+campoEstacion+"` = '"+estacion+"';";
        conexion = obtenerConexion();
        try{
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            // ACTUALIZA LA ESTACION ACTUAL
            while(resultSet.next()){
                if(!resultSet.getString(SEGUNDA_COLUMNA).isEmpty()){
                    estacion = resultSet.getString(SEGUNDA_COLUMNA);
                }
            }
            
            resultSet.close();
            statement.close();
        }catch(SQLException ex){
            reportException(ex.getMessage());
        }
    }
    
    public void atras(){
        System.out.println("Atras");
        String query = "SELECT * FROM `"+tablaBDD+"` WHERE `"+campoSiguienteEstacion+"` = '"+estacion+"';";
        conexion = obtenerConexion();
        try{
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            // ACTUALIZA LA ESTACION ACTUAL
            while(resultSet.next()){
                if(!resultSet.getString(PRIMERA_COLUMNA).isEmpty()){
                    estacion = resultSet.getString(PRIMERA_COLUMNA);
                }
            }
            
            resultSet.close();
            statement.close();
        }catch(SQLException ex){
            reportException(ex.getMessage());
        }
    }

    private Connection obtenerConexion() {
        if (conexion == null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                reportException(ex.getMessage());
            }
            try {
                conexion
                        = DriverManager.getConnection(prefijo + ip + "/" + bdd, user, pswd);
            } catch (Exception ex) {
                reportException(ex.getMessage());
            }
            Runtime.getRuntime().addShutdownHook(new ShutDownHook());
        }
        return conexion;
    }

    private class ShutDownHook extends Thread {

        @Override
        public void run() {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                reportException(ex.getMessage());
            }
        }
    }

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }

    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

    public String getTituloApp() {
        return tituloApp;
    }

    public String getBdd() {
        return bdd;
    }

    public String getTablaBDD() {
        return tablaBDD;
    }

    public String getDriver() {
        return driver;
    }

    public String getIp() {
        return ip;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public String getUser() {
        return user;
    }

    public String getPswd() {
        return pswd;
    }

    public String getCampoEstacion() {
        return campoEstacion;
    }

    public String getCampoSiguienteEstacion() {
        return campoSiguienteEstacion;
    }

    public Connection getConexion() {
        return conexion;
    }

    public ActionListener getListener() {
        return listener;
    }

    public String getBotonAdelante() {
        return botonAdelante;
    }

    public String getBotonAtras() {
        return botonAtras;
    }

    public String getBienvenida() {
        return bienvenida;
    }

    public String getEstacion() {
        return estacion;
    }

    public String getCombinacion() {
        return combinacion;
    }

}
