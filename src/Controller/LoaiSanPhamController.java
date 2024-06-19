/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Connect.Connect;
import Model.LoaiSanPham;
import Model.SanPham;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class LoaiSanPhamController {
    public List<LoaiSanPham> getLoaiSanPham(){
        String sql = "select * from LoaiSP";
        List<LoaiSanPham> lsp = new ArrayList<LoaiSanPham>();
        try {
            Connection db = new Connect().connect(); 
            PreparedStatement prSt = db.prepareStatement(sql);
            
            ResultSet rs = prSt.executeQuery();
            while(rs.next()){
                LoaiSanPham ob = new LoaiSanPham();
                ob.setMaLoaiSP(rs.getString("MaLoaiSP"));
                ob.setTenLoaiSP(rs.getString("TenLoaiSP"));
                lsp.add(ob);
            }
            prSt.close();
            db.close();
                   
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return lsp;
    }
}
