/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connectors;

import java.sql.*;
import javax.swing.JOptionPane;


public class dbconnect {
    private static String url = "jdbc:mysql://localhost:3306/arf";
    private static String user = "root";
    private static String pass = "";
    
    private static Connection connect;
    private static dbconnect dbcon;
    
    public dbconnect(){
        connect = null;
        try{
            connect = DriverManager.getConnection(url,user,pass);
            JOptionPane.showMessageDialog(null, "Connected SuccessFully", "", 0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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