/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Connect.Connect;
import java.util.ArrayList;
import java.util.List;
import Model.CTHoaDon;
import Model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguye
 */
public class CTHoaDonController {
    public List<CTHoaDon> getCTHoaDon(){
        String sql="select * from CTHoaDon";
        List<CTHoaDon> lhd=new ArrayList<CTHoaDon>();
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                 CTHoaDon ob = new CTHoaDon();
                ob.setMaCTHD(rs.getInt("MaCTHD"));
                ob.setMaHD(rs.getString("MaHD"));
                ob.setMaSP(rs.getString("MaSP"));
                ob.setSoLuong(rs.getInt("SoLuong"));
                ob.setThanhTien(rs.getFloat("ThanhTien"));
                
                lhd.add(ob);
            }
        prSt.close();
        db.close();
        }
         catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            }
   return lhd;
    }
    public List<CTHoaDon> getCTHoaDonID( String macthd){
        String sql="select * from CTHoaDon where MaHD="+macthd;
        List<CTHoaDon> lhd=new ArrayList<CTHoaDon>();
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                 CTHoaDon ob = new CTHoaDon();
                ob.setMaCTHD(rs.getInt("MaCTHD"));
                ob.setMaHD(rs.getString("MaHD"));
                ob.setMaSP(rs.getString("MaSP"));
                ob.setSoLuong(rs.getInt("SoLuong"));
                ob.setThanhTien(rs.getFloat("ThanhTien"));
                
                lhd.add(ob);
            }
        prSt.close();
        db.close();
        }
         catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            }
   return lhd;
    }
    public boolean ThemCTHD(CTHoaDon sp){
        String sql = "insert into CTHoaDon values(?,?,?,?)";
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            //prSt.setInt(1, sp.getMaCTHD());
            prSt.setString(1, sp.getMaHD());
            prSt.setString(2, sp.getMaSP());
            prSt.setInt(3, sp.getSoLuong());
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
      public float DonGiaCTHD(String masp){
        List<SanPham> ltSP = new ArrayList<SanPham>();
        String sqlgetPriceSp = "select DonGia from SanPham where MaSP="+masp;
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sqlgetPriceSp);
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                SanPham ob = new SanPham();
                ob.setDonGia(rs.getFloat("DonGia"));
                ltSP.add(ob);
            }
            prSt.close();
            db.close();
                  
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return (float)ltSP.get(0).getDonGia();
    }
      
      
      public void HuyHD( String mahd){
        String sql="delete MaCTHD from CTHoaDon  where MaHD="+mahd;
        //List<CTHoaDon> lhd=new ArrayList<CTHoaDon>();
        try{
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            ResultSet rs = prSt.executeQuery();
            
            prSt.close();
            db.close();
            //System.out.println("Hủy thành công");
        }
         catch (Exception e) {
            //System.out.println("Thất bại");
          
            }
 
      }

    public List<CTHoaDon> getChiTietHoaDonID(String maCThd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
      
    
    
    
    
}
