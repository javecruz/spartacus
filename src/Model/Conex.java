package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conex {
    
    Connection con = null;
    
   
   
     public com.mysql.jdbc.Connection AbrirConexion() throws SQLException{
        
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.20.189:3306/spartacus";
            String user = "root";
            String pass = "";
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion BBDD ABRIENDO");
                    
                    
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR EN LA CONEXION CON BBDD");
        }
    
      return (com.mysql.jdbc.Connection) con;
    }
    
    
    public void CerrarConexion(Connection con) {
    
        if(con!=null){
        
            try {
                con.close();
                System.out.println("Conexion BBDD CERRADA");
            } catch (SQLException ex) {
                Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    
    
    
    }

        
              

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*public Conex(){
        try { 
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problema cargando drivers");
        }
    String url = "jdbc:mysql://192.168.20.189:3306/spartacus";
   String user = "root";
   String pass = "";
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de conexión!");
        }
    }*/
    
    
    
    
}
