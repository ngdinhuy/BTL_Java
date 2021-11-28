/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC_Connection;

import Data.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mac
 */
public class SolveSanPham {
    public static SanPham getSanPham(String code){
        SanPham sanPham=new SanPham(0,"","",0,0,0);
        try {
            Connection con=JDBC_Connection.get_connConnection();
            String sql="select * from SanPham where code=?";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1, code);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                sanPham.setID(rs.getInt("id"));
                sanPham.setCode(code);
                sanPham.setName(rs.getString("name"));
                sanPham.setsPrice(rs.getInt("s_price"));
                sanPham.setmPrice(rs.getInt("m_price"));
                sanPham.setlPrice(rs.getInt("l_price"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sanPham;
    }
    
    
    public static ArrayList<SanPham> getAllSanPham(){
        ArrayList<SanPham> A = new ArrayList<>();
        try {
            Connection con=JDBC_Connection.get_connConnection();
            Statement statement=con.createStatement();
            String sql="select * from SanPham";
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                SanPham p=new SanPham(0,"","",0,0,0);
                p.setID(rs.getInt("ID"));
                p.setCode(rs.getString("code"));
                p.setName(rs.getString("name"));
                p.setlPrice(rs.getInt("l_price"));
                p.setmPrice(rs.getInt("m_price"));
                p.setsPrice(rs.getInt("s_price"));
                A.add(p);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
         return A;

    }
    
    public static void editSanPham(SanPham sanPham){
        try {
            Connection con=JDBC_Connection.get_connConnection();
            String sql="Update SanPham set name=?, s_price=?, m_price=?, l_price=? where code=?";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,sanPham.getName());
            preparedStatement.setInt(2, sanPham.getsPrice());
            preparedStatement.setInt(3, sanPham.getmPrice());
            preparedStatement.setInt(4, sanPham.getlPrice());
            preparedStatement.setString(5, sanPham.getCode());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addSanPham(SanPham sanPham){
        try {
            Connection con=JDBC_Connection.get_connConnection();
            String sql="Insert into SanPham(code, name, s_price,m_price,l_price) values(?,?,?,?,?)";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,sanPham.getCode());
            preparedStatement.setString(2,sanPham.getName());
            preparedStatement.setInt(3, sanPham.getsPrice());
            preparedStatement.setInt(4, sanPham.getmPrice());
            preparedStatement.setInt(5, sanPham.getlPrice());
            preparedStatement.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public static void deleteSanPham(String code){
        try {
            Connection con=JDBC_Connection.get_connConnection();
            String sql="delete from SanPham where code=?";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,code);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SolveSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        deleteSanPham("CF04");
//    }
}
