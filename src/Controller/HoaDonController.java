/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connect.Connect;
import Model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class HoaDonController {
    public List<HoaDon> getHoaDon() {
        String sql="select* from HoaDon";
        List<HoaDon> hd = new ArrayList<HoaDon>();
        try{
        Connection db = new Connect().connect(); 
        //thuc thi
        PreparedStatement prSt = db.prepareStatement(sql);
        //do du lieu
        ResultSet rs = prSt.executeQuery();
        while(rs.next()){
                HoaDon ob = new HoaDon();
                ob.setMaHD(rs.getString("MaHD"));
                ob.setMaNV(rs.getString("MaNV"));
                ob.setNgayXuat(rs.getString("NgayXuat"));
                ob.setThanhTien(rs.getFloat("ThanhTien"));
                hd.add(ob);
            }
        prSt.close();
        db.close();
        }catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            }
        return hd;   
    }
    public boolean ThemHoaDon(HoaDon sp){
        String sql = "insert into HoaDon values(?,?,?,?)";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, sp.getMaHD());
            prSt.setString(2, sp.getMaNV());
            prSt.setString(3, sp.getNgayXuat());
            prSt.setFloat(4, sp.getThanhTien());

            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    public boolean SuaHoaDon(HoaDon sp){
        String sql = "update HoaDon set MaNV = ? , NgayXuat = ?, ThanhTien = ? where MaHD = ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(4, sp.getMaHD());
            prSt.setString(1, sp.getMaNV());
            prSt.setString(2, sp.getNgayXuat());
            prSt.setFloat(3, sp.getThanhTien());

            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    public boolean XoaHoaDon(HoaDon sp){
              String sql = "delete from HoaDon where MaHD = ? ";
            try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, sp.getMaHD());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
            } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
        
    }
    
}
