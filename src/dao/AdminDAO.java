/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import javax.swing.JOptionPane;
import model.Admin;

/**
 *
 * @author dharm
 */
public class AdminDAO {
    public static Admin login(String email, String password)
    {
        Admin admin = null;
        try {
            String query = "SELECT * FROM admin where email='"+email+"' AND password='"+password+"'";
            ResultSet rs = DbOperations.getData(query);
            while(rs.next())
            {
                admin = new Admin();
                email = rs.getString("email");
                password = rs.getString("password");
                admin.setEmail(email);
                admin.setPassword(password);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Some error occured");
        }
        return admin;
    }
    
}
