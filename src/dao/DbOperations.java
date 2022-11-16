/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author dharm
 */
public class DbOperations {
    public static void setDataorDelete(String Query, String msg)
    {
        try{
            // fetching the connection 
            Connection con =  ConnectionProvider.getCon();
            Statement st = (Statement) con.createStatement();
//            System.out.print(st);
            // we will use execute update for statements which don't return output 
            st.executeUpdate(Query);
            if(!msg.equals(""))
                JOptionPane.showMessageDialog(null, msg);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ResultSet getData(String query)
    {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement stmt = con.createStatement();
            // as now the query will return the result set 
            ResultSet rs =  stmt.executeQuery(query);
//            System.out.println(rs+" hehe");
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Some error occured");
        }
        return null;
    }
}
