
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    static public String driver = "com.mysql.cj.jdbc.Driver";
    static public String  url= "jdbc:mysql://localhost:3307/bd_blog";
    static public String  usuario= "root"; 
    static public String  password= "12768327";
    
    protected Connection conn = null;
    
    public ConexionDB(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR EN EL DRIVER" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("ERROR AL CONECTARRRRRRRR" + ex.getMessage());
        }
        
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERRORR AL DESCONETAR"+ex.getMessage());
        }
    }

    
}
