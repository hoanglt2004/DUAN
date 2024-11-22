// Monhoc.java
package model;

public class Monhoc {
    private String mamon;
    private String tenmonhoc;
    private int sotinchi;
    
    // Constructors
    public Monhoc() {}
    
    public Monhoc(String mamon, String tenmonhoc, int sotinchi) {
        this.mamon = mamon;
        this.tenmonhoc = tenmonhoc;
        this.sotinchi = sotinchi;
    }
    
    // Getters and Setters
    public String getMamon() { return mamon; }
    public void setMamon(String mamon) { this.mamon = mamon; }
    
    public String getTenmonhoc() { return tenmonhoc; }
    public void setTenmonhoc(String tenmonhoc) { this.tenmonhoc = tenmonhoc; }
    
    public int getSotinchi() { return sotinchi; }
    public void setSotinchi(int sotinchi) { this.sotinchi = sotinchi; }
}