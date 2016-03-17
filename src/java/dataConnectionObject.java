

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dataConnectionObject {
    public Connection getConnection() {
        boolean status = false;
        Connection conn = null;
        Object pst = null;
        Object rs = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "cycapp_temp";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "admin@itspe";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(dataConnectionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(dataConnectionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(dataConnectionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(dataConnectionObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}