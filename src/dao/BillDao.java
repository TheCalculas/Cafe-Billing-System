/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Bill;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.RecordHaving;

/**
 *
 * @author dharm
 */
public class BillDao {

    public static String getId() {
        int id = 1;
        try {
            String query = "SELECT MAX(id) FROM bill";
            ResultSet rs = DbOperations.getData(query);
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);

    }
    
    
    
    public static void save(Bill bill)
    {
        String query = "INSERT INTO bill VALUES ("+bill.getId() + " , '" + bill.getName()+"' , "+bill.getMobileNumber()+", '"+ bill.getEmail()+"', '"+bill.getDate()+"', "+bill.getTotal()+", '"+bill.getCreatedBy()+"');";
        DbOperations.setDataorDelete(query, "Bill added successfully");
    }
    
    public static ArrayList<String> findNameandMobileByEmail(String email)
    {
        ArrayList<String> arrlis = new ArrayList<String>();
        try {
            String name ="";
            String mob = "";
            String query = "SELECT (name, mobileNumber) from user where email ='"+email+"'";
            ResultSet rs =  DbOperations.getData(query);
            if(rs.next())
            {
                name = rs.getString("name");
                mob = String.valueOf(rs.getLong("mobileNumber"));
                arrlis.add(name);
                arrlis.add(mob);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrlis;
    }
    
    
    public static ArrayList<Bill> getAllRecordsByInc(String date){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("Select * from bill where date like '%"+date+"%'");
            while(rs.next()){
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getInt("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
    
    public static ArrayList<Bill> getAllRecordsByDesc(String date){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("Select * from bill where date like '%"+date+"%' order by id DESC");
            while(rs.next()){
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getInt("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
    // These are the user modules 
    
    public static int lifeTimeSpent(String email)
    {
        int total = 0;
        try {
            ResultSet rs = DbOperations.getData("Select SUM(total)as Total FROM Bill where email='"+email+"'");
            while(rs.next())
            {
                total = rs.getInt("Total");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
        }
        return total;
        
    }
    public static ArrayList<Bill> getAllRecordsByIncUser(String date, String email){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("Select * from bill where date like '%"+date+"%' and email ='"+email+"'");
            while(rs.next()){
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getInt("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
    
    // it gives all the records having count
    public static ArrayList<RecordHaving> getRecordsHaving(String count){
        ArrayList<RecordHaving> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("Select count(*) as TotalBills, email, SUM(total) as Spent from bill GROUP BY email HAVING COUNT(*)>"+Integer.parseInt(count)+" ORDER BY COUNT(*) DESC");
            while(rs.next()){
                RecordHaving rh = new RecordHaving();
                rh.setCount(rs.getInt("TotalBills"));
                rh.setEmail(rs.getString("email"));
                rh.setSpent(rs.getInt("Spent"));
                arrayList.add(rh);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
    
    
    
    public static ArrayList<Bill> getAllRecordsByDescUser(String date, String email){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("Select * from bill where date like '%"+date+"%' and email ='"+email+"' order by id DESC");
            while(rs.next()){
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getInt("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(bill);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
}
