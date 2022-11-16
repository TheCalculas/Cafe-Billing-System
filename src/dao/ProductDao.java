/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;

/**
 *
 * @author dharm
 */
public class ProductDao {
    public static void save(Product product)
    {
        String query = "INSERT INTO product (name, category, price) values('"+product.getName()+"', '"+product.getCategory()+"', '"+product.getPrice()+"')";
        DbOperations.setDataorDelete(query, "Product inserted successfully");
    }
    
    public static ArrayList<Product> getAllRecords()
    {
        ArrayList<Product> pro= new ArrayList<>();
        try {
            
            ResultSet rs = DbOperations.getData("SELECT * FROM PRODUCT");
            while(rs.next())
            {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setCategory(rs.getString("category"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
//                System.out.println(product.getPrice());
                pro.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return pro;
    }
    public static void update(Product p)
    {
        String q = "UPDATE product set name ='"+p.getName()+"', category ='"+p.getCategory()+"',price ='"+p.getPrice()+"' WHERE id ="+p.getId()+";";
        DbOperations.setDataorDelete(q, "Product updated successfully");
    }
    
    public static void delete(int id)
    {
        String q = "DELETE FROM PRODUCT WHERE id ="+id+"";
        DbOperations.setDataorDelete(q, "Product Deleted Successfully");
    }
    
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> a = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE category ='"+category+"';");
            while(rs.next())
            {
                Product product = new Product();
                product.setName(rs.getString("name"));
                a.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
                    
        }
        return a;
    }
    public static ArrayList<Product> getProductByName(String category, String name){
        ArrayList<Product> a = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name like '%"+name+"%' and category ='"+category+"'");
            while(rs.next())
            {
                Product product = new Product();
                product.setName(rs.getString("name"));
                a.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can't get product by name");
                    
        }
        return a;
    }
    
    public static Product getProductByNameAndSet(String name){
        Product p = new Product();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name like '%"+name+"%'");
            while(rs.next())
            {
                p.setName(rs.getString(2));
                p.setCategory(rs.getString(3));
                p.setPrice(rs.getInt(4));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
                    
        }
        return p;
    }
}
