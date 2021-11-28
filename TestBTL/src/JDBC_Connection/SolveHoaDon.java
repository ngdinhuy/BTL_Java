/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_Connection;

import Data.HoaDon;
import com.mysql.cj.jdbc.ConnectionImpl;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mac
 */
public class SolveHoaDon {
    public static ArrayList<HoaDon> getAllHoaDon(){
        ArrayList<HoaDon> A=new ArrayList<>();
        String sql="select * from HoaDon";
        Connection con;
        try {
            con = JDBC_Connection.get_connConnection();
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                HoaDon hoaDon=new HoaDon(0,"","",0,0);
                hoaDon.setMa(rs.getString("code"));
                hoaDon.setStt(rs.getInt("STT"));
                hoaDon.setName(rs.getString("name"));
                hoaDon.setSize(rs.getString("size"));
                hoaDon.setPrice(rs.getInt("price"));
                hoaDon.setSoLuong(rs.getInt("soluong"));
                A.add(hoaDon);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return A;
    }
    
    
    public static HoaDon getHoaDon(int stt){
        HoaDon hoaDon= new HoaDon(0,"","",0,0);
        try {
            Connection con=JDBC_Connection.get_connConnection();
            String sql="select * from HoaDon where STT=?";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setInt(1, stt);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                hoaDon.setMa(rs.getString("Code"));
                hoaDon.setStt(stt);
                hoaDon.setName(rs.getString("name"));
                hoaDon.setSize(rs.getString("size"));
                hoaDon.setPrice(rs.getInt("price"));
                hoaDon.setSoLuong(rs.getInt("soLuong"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hoaDon;
    }
    
    
    public static void addHoaDon(HoaDon hoaDon){
        try {
            Connection con=JDBC_Connection.get_connConnection();
            String sql="insert into HoaDon(name,code,size,price,soluong)" +
                    "values(?,?,?,?,?)";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,hoaDon.getName());
            preparedStatement.setString(2, hoaDon.getMa());
            preparedStatement.setString(3, hoaDon.getSize());
            preparedStatement.setInt(4,hoaDon.getPrice());
            preparedStatement.setInt(5, hoaDon.getSoLuong());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void editHoaDon(HoaDon hoaDon){
        try {
            Connection con=JDBC_Connection.get_connConnection();
            String sql="Update HoaDon set name=?, size=?, price=?, soLuong=? where stt=?";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,hoaDon.getName());
            preparedStatement.setString(2, hoaDon.getSize());
            preparedStatement.setInt(3, hoaDon.getPrice());
            preparedStatement.setInt(4, hoaDon.getSoLuong());
            preparedStatement.setInt(5, hoaDon.getStt());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void deleteHoaDon(int stt){
        try {
            Connection con=JDBC_Connection.get_connConnection();
            String sql="delete from HoaDon where STT=?";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setInt(1, stt);
            preparedStatement.execute();
            String sqlUpdate1="ALTER TABLE HoaDon DROP stt;";
            String sqlUpdate2 ="ALTER TABLE HoaDon ADD stt int not null auto_increment primary key first;";
            Statement statement=con.createStatement();
            statement.addBatch(sqlUpdate1);
            statement.addBatch(sqlUpdate2);
            statement.executeBatch();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static int sumHoaDon(){
        int sum=0;
        try {
            Connection con=JDBC_Connection.get_connConnection();
            Statement statement=con.createStatement();
            String sql1="select * from HoaDon";
            ResultSet rs=statement.executeQuery(sql1);
            while(rs.next()){
                sum=sum+rs.getInt("soLuong")*rs.getInt("Price");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }
//    public static void main(String[] args) {
//        
////        ArrayList<HoaDon> A=new ArrayList<>();
////        try {
////            A=getAllHoaDon();
////        } catch (ClassNotFoundException ex) {
////            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (SQLException ex) {
////            Logger.getLogger(SolveHoaDon.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        for(int i=0;i<A.size();i++){
////            System.out.println(A.get(i));
////        }
//
////          HoaDon p=new HoaDon(0,"","",0,0);
////          p=getHoaDon(1);
////          System.out.println(p);
//          
////            HoaDon p=new HoaDon(0,"huy","L",50000,2);
////            SolveHoaDon.addHoaDon(p);
//
//            //HoaDon p=new HoaDon(4,"thuan","S",50000,3);
//            
//            
//            SolveHoaDon.sumHoaDon();
//    }
}
