// Diemthi.java
package model;

public class Diemthi {
    private String mamon;
    private String masv;
    private float diemlan1;
    private float diemlan2;
    
    // Constructors
    public Diemthi() {}
    
    public Diemthi(String mamon, String masv, float diemlan1, float diemlan2) {
        this.mamon = mamon;
        this.masv = masv;
        this.diemlan1 = diemlan1;
        this.diemlan2 = diemlan2;
    }
    
    // Getters and Setters
    public String getMamon() { return mamon; }
    public void setMamon(String mamon) { this.mamon = mamon; }
    
    public String getMasv() { return masv; }
    public void setMasv(String masv) { this.masv = masv; }
    
    public float getDiemlan1() { return diemlan1; }
    public void setDiemlan1(float diemlan1) { this.diemlan1 = diemlan1; }
    
    public float getDiemlan2() { return diemlan2; }
    public void setDiemlan2(float diemlan2) { this.diemlan2 = diemlan2; }
}