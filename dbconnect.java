
package Controller_Connectors;

import java.sql.*;
import javax.swing.JOptionPane;

public class dbconnect {
    private static String url = "jdbc:mysql://localhost:3306/ARF";
    private static String user = "root";
    private static String pass = "";
    
    private static Connection connect;
    private static dbconnect dbcon;
    
     public dbconnect(){
        connect = null;
        try {
            connect = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "Welcome to MCC Apartment \n    Where you feel at Home", "ApartmentInterface", 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error!", "Not Connected", 0);
        }
    }
    public static dbconnect getdbconnection(){
        if(dbcon == null){
            dbcon = new dbconnect();
        }
        return dbcon;
    }
    public static Connection getConnection(){
    
        return connect;
    }
}
