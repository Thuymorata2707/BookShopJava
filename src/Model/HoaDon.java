/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.CTHoaDon;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String MaHD;
    private String MaNV;
    private float ThanhTien; 
    private String NgayXuat;

    
    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaNV, float ThanhTien, String NgayXuat) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.ThanhTien = ThanhTien;
        this.NgayXuat = NgayXuat;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public float getThanhTien() {
        return ThanhTien ;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(String NgayXuat) {
        this.NgayXuat = NgayXuat;
    }
    
    
}
