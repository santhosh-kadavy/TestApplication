/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author itspe
 */
public class PostGISConnectionObject {
    java.sql.Connection conn;
    public Connection getConnection(){
        try { 
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostGISConnectionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:postgresql://localhost:5432/cycapp"; 
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostGISConnectionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
           //conn = DriverManager.getConnection(url, "postgres", "postgres");
           conn = DriverManager.getConnection(url, "postgres", "itspe");
        } catch (SQLException ex) {
            Logger.getLogger(PostGISConnectionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
}
