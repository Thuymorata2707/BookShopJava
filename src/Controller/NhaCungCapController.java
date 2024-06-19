/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connect.Connect;
import Model.NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhaCungCapController {
    public List<NhaCungCap> getNhaCungCap(){
        String sql = "select * from NhaCungCap";
        List<NhaCungCap> lncc = new ArrayList<NhaCungCap>();
        try {
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                NhaCungCap ob = new NhaCungCap();
                ob.setMaNCC(rs.getString("MaNCC"));
                ob.setTenNCC(rs.getString("TenNCC"));
                ob.setSDT(rs.getString("SĐT"));
                ob.setDiaChi(rs.getString("DiaChi"));
                lncc.add(ob);
            }
            prSt.close();
            db.close();
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return lncc;
    }
    
    public boolean ThemNhaCungCap(NhaCungCap sp){
        String sql = "insert into NhaCungCap values(?,?,?,?)";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, sp.getMaNCC());
            prSt.setString(2, sp.getTenNCC());
            prSt.setString(3, sp.getSDT());
            prSt.setString(4, sp.getDiaChi());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    
    public boolean SuaNhaCungCap(NhaCungCap sp){
        String sql = "update NhaCungCap set TenNCC = ?, SĐT = ?, DiaChi = ? where MaNCC = ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(4, sp.getMaNCC());
            prSt.setString(1, sp.getTenNCC());
            prSt.setString(2, sp.getSDT());
            prSt.setString(3, sp.getDiaChi());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    public boolean XoaNhaCungCap(NhaCungCap sp){
        String sql = "delete from NhaCungCap where MaNCC = ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, sp.getMaNCC());
            
            int r = prSt.executeUpdate();
            prSt.close();
            db.close();
            return r == 1;
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            return false;
        }
    }
    public List<NhaCungCap> TimKiemNhaCungCap(String TenNCC){
        List<NhaCungCap> ltNCC = new ArrayList<NhaCungCap>();
        String sql = "select * from NhaCungCap where TenNCC like ? ";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            prSt.setString(1, "%"+ TenNCC + "%" );
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                NhaCungCap ob = new NhaCungCap();
                ob.setMaNCC(rs.getString("MaNCC"));
                ob.setTenNCC(rs.getString("TenNCC"));
                ob.setSDT(rs.getString("SĐT"));
                ob.setDiaChi(rs.getString("DiaChi"));
                ltNCC.add(ob);
            }
            prSt.close();
            db.close();
                  
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return ltNCC;
    }
}
