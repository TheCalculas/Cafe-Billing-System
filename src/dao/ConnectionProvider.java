/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
/**
 *
 * @author dharm
 */
// Basically it is getting connection between mysql and java 
public class ConnectionProvider {
    public static Connection getCon()
    {
        try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "root", "123456");
           return con;
        }   
        
        catch(ClassNotFoundException | SQLException e)
        {
            return null;
        }
    }
    
}
