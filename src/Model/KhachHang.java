/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String MaKH;
    private String TenKH;
    private String NgayMua;
    private String DiaChi;
    private String SDT;
    private String MaSP;

    public KhachHang() { }

    public KhachHang(String MaKH, String TenKH, String NgayMua, String DiaChi, String SDT, String MaSP) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.NgayMua = NgayMua;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.MaSP = MaSP;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(String NgayMua) {
        this.NgayMua = NgayMua;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    
    
    
    
}
