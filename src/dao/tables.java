/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author dharm
 */

// this has a main file toh execute the code by itself only
public class tables {
    public static  void main(String[] args)
    {
        try{
            String userTable ="create table user(id int auto_increment primary key, name varchar(70) unique not null, email varchar(70) unique, mobileNumber varchar(20), address varchar(100), password varchar(30), nickName varchar(30));";
            DbOperations.setDataorDelete(userTable, "Table Created :)");
            
            String adminTable ="create table admin(id int auto_increment primary key, name varchar(70), email varchar(70) unique, mobileNumber bigint(20), address varchar(100), password varchar(30))";
            DbOperations.setDataorDelete(adminTable, "Admin Table Created successfully");
            
            String adminTableInsert ="insert into admin (name, email, mobileNumber, address, password) values ('Admin', 'Admin@admin.com', 9829722745, 'abc', 'admin')";
            DbOperations.setDataorDelete(adminTableInsert, "Admin inserted successfully");
            
            String categoryTable = "create table category(id int auto_increment primary key, name varchar(40) unique not null);";
            DbOperations.setDataorDelete(categoryTable, "Category table created successfully"); 
            
            String productTable = "create table product (id int auto_increment primary key, name varchar(40), category varchar(40), price bigint(40), CONSTRAINT const1 FOREIGN KEY (category) REFERENCES category(name));";
            DbOperations.setDataorDelete(productTable, "Product table created successfully"); 
            
            String billTable = "create table bill (id int primary key, name varchar(40), mobileNumber bigint(20), email varchar(70), date Date, total int(20), createdBy varchar(20), status varchar(20), CONSTRAINT c2 FOREIGN KEY (email) REFERENCES user(email));";
            DbOperations.setDataorDelete(billTable, "Bill table created successfully");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
