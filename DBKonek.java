/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Connectors;

import java.sql.*;
import javax.swing.JOptionPane;


//database connection
public class DBKonek {
    private static String url = "jdbc:mysql://localhost:3306/ARF";
    private static String user = "root";
    private static String pass = "";
    
    private static Connection konn;
    private static DBKonek dbkonek;
    
    public DBKonek(){
        konn = null;
        try {
            konn = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "Welcome to MCC Apartment \n    Where you feel at Home", "ApartmentInterface", 0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error!", "Not Connected", 0);
        }
    }
    public static DBKonek getDBConnection(){
        if(dbkonek == null){
            dbkonek = new DBKonek();
        }
        return dbkonek;
    }
    public static Connection getConnection(){
    
        return konn;
    }
}
