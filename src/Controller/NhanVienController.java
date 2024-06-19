/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connect.Connect;
import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienController {
    public List<NhanVien> getNhanVien(){
        String sql = "select * from NhanVien";
        List<NhanVien> lnv = new ArrayList<NhanVien>();
        try {
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                NhanVien ob = new NhanVien();
                ob.setMaNV(rs.getString("MaNV"));
                ob.setTenNV(rs.getString("TenNV"));
                ob.setNgaySinh(rs.getString("NgaySinh"));
                ob.setGioiTinh(rs.getString("GioiTinh"));
                ob.setDiaChi(rs.getString("DiaChi"));
                ob.setChucVu(rs.getString("ChucVu"));
                ob.setSDT(rs.getString("SĐT"));
                ob.setTaiKhoan(rs.getString("TaiKhoan"));
               
                lnv.add(ob);
            }
            prSt.close();
            db.close();
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return lnv;
    }
    
    public boolean ThemNhanVien(NhanVien sp){
        String sql = "insert into NhanVien values(?,?,?,?,?,?,?,?)";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, sp.getMaNV());
            prSt.setString(2, sp.getTenNV());
            prSt.setString(3, sp.getNgaySinh());
            prSt.setString(4, sp.getGioiTinh());
            prSt.setString(5, sp.getDiaChi());
            prSt.setString(6, sp.getChucVu());
            prSt.setString(7, sp.getSDT());
            prSt.setString(8, sp.getTaiKhoan());

            
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    
    public boolean SuaNhanVien(NhanVien sp){
        String sql = "update NhanVien set TenNV = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, ChucVu = ?, SĐT= ?, TaiKhoan = ? where MaNV = ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(8, sp.getMaNV());
            prSt.setString(1, sp.getTenNV());
            prSt.setString(2, sp.getNgaySinh());
            prSt.setString(3, sp.getGioiTinh());
            prSt.setString(4, sp.getDiaChi());
            prSt.setString(5, sp.getChucVu());
            prSt.setString(6, sp.getSDT());
            prSt.setString(7, sp.getTaiKhoan());

            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    public boolean XoaNhanVien(NhanVien sp){
        String sql = "delete from NhanVien where MaNV = ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, sp.getMaNV());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    public List<NhanVien> TimKiemNhanVien(String TenNV){
        List<NhanVien> ltNV = new ArrayList<NhanVien>();
        String sql = "select * from NhanVien where TenNV like ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, "%"+ TenNV + "%" );
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                NhanVien ob = new NhanVien();
                ob.setMaNV(rs.getString("MaNV"));
                ob.setTenNV(rs.getString("TenNV"));
                ob.setNgaySinh(rs.getString("NgaySinh"));
                ob.setGioiTinh(rs.getString("GioiTinh"));
                ob.setDiaChi(rs.getString("DiaChi"));
                ob.setChucVu(rs.getString("ChucVu"));
                ob.setSDT(rs.getString("SĐT"));
                ob.setTaiKhoan(rs.getString("TaiKhoan"));
               
                ltNV.add(ob);
            }
            prSt.close();
            db.close();
                  
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return ltNV;
    }
}
    

