/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Category;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author dharm
 */
public class CategoryDao {
    public static void save(Category name)
    {
        String query = "insert into category (name) values ('"+name.getName()+"')";
        DbOperations.setDataorDelete(query, "Category added successfully");
        
    }
    // this function will fetch all the records 
    public static ArrayList <Category> getAllRecords()
    {
        ArrayList<Category> a = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM category");
            while(rs.next())
            {
                Category cat = new Category();
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
                a.add(cat);
            }
            return a;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        
        return a;
    }
    
    public static void delete(String id)
    {
        String query = "DELETE FROM category WHERE id ="+id+"";
        DbOperations.setDataorDelete(query, "Category Deleted Successfully");
    }
}
