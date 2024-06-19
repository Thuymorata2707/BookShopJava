/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Connect.Connect;
import java.sql.PreparedStatement;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class NguoiDungController {
    Connect dbcon = new Connect();
    public boolean Login(String TaiKhoan, String MatKhau){
        try {
            Connection conn = dbcon.connect();
            String query = "select count(*) as SoLuong from NguoiDung where TaiKhoan = ? and MatKhau = ?";
            PreparedStatement prSt = conn.prepareStatement(query);
            prSt.setString(1, TaiKhoan);
            prSt.setString(2, MatKhau);
            ResultSet rs = prSt.executeQuery();
            rs.next();
             
            int soLuong = rs.getInt("SoLuong");
            prSt.close();
            conn.close();
            return soLuong == 1;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return false;
        
    }
}
