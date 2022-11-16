/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.User;
/**
 *
 * @author dharm
 */


// It contains all the queries for inserting and saving the user operations 
public class UserDAO {
    public static void save(User user)
    {
        
        String query = "INSERT INTO user (name, email, mobileNumber, address, password, nickName) VALUES('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getNickName()+"')";
        DbOperations.setDataorDelete(query, "Inserted Successfully");
    }
    
    public static User login(String email, String password)
    {
        User user = null;
        try {
            String query = "SELECT * FROM user where email='"+email+"' AND password='"+password+"';";
            ResultSet rs = DbOperations.getData(query);
            
//            System.out.print(rs);
//            System.out.println("the status is: "+rs); result set aa rha hai phirk ya ho rha hai bisi
            while(rs.next())
            {
                user = new User();
                email = rs.getString("email");
                password = rs.getString("password");
                user.setEmail(email);
                user.setPassword(password);
             
            }
//            System.out.println("the user is"+ user.getEmail());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Some error occured");
        }
        // this will return the user 
        return user;
    }
    public static ArrayList<User> getAllRecords(String email)
    {
        ArrayList<User> user = new ArrayList<>();
        
        try {
            String query = "Select * from user WHERE email LIKE '"+email+"%'";
            ResultSet rs = DbOperations.getData(query);
            while(rs.next())
            {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setMobileNumber(rs.getString("mobileNumber"));
                u.setAddress(rs.getString("address"));
                user.add(u);
                        
            }
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    public static ArrayList<User> getAllRecords()
    {
        ArrayList<User> user = new ArrayList<>();
        
        try {
            String query = "Select * from user";
            ResultSet rs = DbOperations.getData(query);
            while(rs.next())
            {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setMobileNumber(rs.getString("mobileNumber"));
                u.setAddress(rs.getString("address"));
                user.add(u);
                        
            }
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    public static boolean isThere(String email, String name, String mobileNumber, String nickName)
    {
        System.out.println(email+" "+name+" "+mobileNumber+nickName);
        boolean flag = false;
        try {
            String query = "select * from user where name='"+name+"' and email='"+email+"' and mobileNumber='"+mobileNumber+"' and nickName='"+nickName+"';";
            System.out.print(query);
            ResultSet rs = DbOperations.getData(query);
            System.out.println(rs);
            while(rs.next())
            {
                flag = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, flag);
        }
        return flag;
    }
    public static void updateUser(String email, String password)
    {
        try {
            String query = "Update user set password='"+password+"' where email='"+email+"'";
            DbOperations.setDataorDelete(query, "Password changed successfully");
        } catch (Exception e) {
        }
    }
}
