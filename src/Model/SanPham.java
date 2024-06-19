/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * @author Admin *

 */
public class SanPham {
    public String MaSP;
    private String TenSP;
    private String MoTa;
    private int SoLuong;
    private float DonGia;
    private String MaLoaiSP;

    public SanPham() {
    }
    

    public SanPham(String MaSP, String TenSP, String MoTa, int SoLuong, float DonGia, String MaLoaiSP) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MoTa = MoTa;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.MaLoaiSP = MaLoaiSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    

    public void setMaLoaiSP(String MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }
    
    

}

    