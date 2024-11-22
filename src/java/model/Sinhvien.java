// Sinhvien.java
package model;

import java.util.Date;

public class Sinhvien {
    private String masv;
    private String hoten;
    private Date ngaysinh;
    private String gioitinh;
    private String malop;
    
    // Constructors
    public Sinhvien() {}
    
    public Sinhvien(String masv, String hoten, Date ngaysinh, String gioitinh, String malop) {
        this.masv = masv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.malop = malop;
    }
    
    // Getters and Setters
    public String getMasv() { return masv; }
    public void setMasv(String masv) { this.masv = masv; }
    
    public String getHoten() { return hoten; }
    public void setHoten(String hoten) { this.hoten = hoten; }
    
    public Date getNgaysinh() { return ngaysinh; }
    public void setNgaysinh(Date ngaysinh) { this.ngaysinh = ngaysinh; }
    
    public String getGioitinh() { return gioitinh; }
    public void setGioitinh(String gioitinh) { this.gioitinh = gioitinh; }
    
    public String getMalop() { return malop; }
    public void setMalop(String malop) { this.malop = malop; }
}