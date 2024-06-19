/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connect.Connect;
import Model.SanPham;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamController {
    public List<SanPham> getSanPham(){
        String sql = "select * from SanPham";
        List<SanPham> lsp = new ArrayList<SanPham>();
        try {
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                SanPham ob = new SanPham();
                ob.setMaSP(rs.getString("MaSP"));
                ob.setTenSP(rs.getString("TenSP"));
               ob.setSoLuong(rs.getInt("SoLuong"));
                ob.setMoTa(rs.getString("MoTa"));
                ob.setDonGia(rs.getFloat("DonGia"));
                ob.setMaLoaiSP(rs.getString("MaLoaiSP"));
                lsp.add(ob);
            }
            prSt.close();
            db.close();
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return lsp;
    }
    
    public boolean ThemSanPham(SanPham sp){
        String sql = "insert into SanPham values(?,?,?,?,?,?)";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, sp.getMaSP());
            prSt.setString(2, sp.getTenSP());
            prSt.setInt(3, sp.getSoLuong());
            prSt.setString(4, sp.getMoTa());
            prSt.setFloat(5, sp.getDonGia());
            prSt.setString(6, sp.getMaLoaiSP());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    
    public boolean SuaSanPham(SanPham sp){
        String sql = "update SanPham set TenSP = ?, MoTa = ?, SoLuong = ?, DonGia = ?, MaLoaiSP = ? where MaSP = ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(6, sp.getMaSP());
            prSt.setString(1, sp.getTenSP());
            prSt.setString(2, sp.getMoTa());
            prSt.setInt(3, sp.getSoLuong());
            prSt.setFloat(4, sp.getDonGia());
            prSt.setString(5, sp.getMaLoaiSP());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    public boolean XoaSanPham(SanPham sp){
        String sql = "delete from SanPham where MaSP = ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, sp.getMaSP());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    public List<SanPham> TimKiemSanPham(String TenSP){
        List<SanPham> ltSP = new ArrayList<SanPham>();
        String sql = "select * from SanPham where TenSP like ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, "%"+ TenSP + "%" );
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                SanPham ob = new SanPham();
                ob.setMaSP(rs.getString("MaSP"));
                ob.setTenSP(rs.getString("TenSP"));
                ob.setMoTa(rs.getString("MoTa"));
                ob.setSoLuong(rs.getInt("SoLuong"));
                ob.setDonGia(rs.getFloat("DonGia"));
                ob.setMaLoaiSP(rs.getString("MaLoaiSP"));
                ltSP.add(ob);
            }
            prSt.close();
            db.close();
                  
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return ltSP;
    }
}
