// DiemthiDAO.java
package dao;

import model.Diemthi;
import java.sql.*;
import java.util.*;

public class DiemthiDAO extends BaseDAO {
    
    public List<Map<String, Object>> getSinhvienTTNT() throws SQLException, ClassNotFoundException {
        List<Map<String, Object>> results = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT sv.Masv, sv.Hoten, sv.Ngaysinh, mh.Tenmonhoc, " +
                        "GREATEST(COALESCE(dt.Diemlan1, 0), COALESCE(dt.Diemlan2, 0)) as Diemcaonhat " +
                        "FROM Sinhvien sv " +
                        "JOIN Diemthi dt ON sv.Masv = dt.Masv " +
                        "JOIN Monhoc mh ON dt.Mamon = mh.Mamon " +
                        "WHERE mh.Mamon = 'TTNT' " +
                        "AND (dt.Diemlan1 >= 8.5 OR dt.Diemlan2 >= 8.5) " +
                        "ORDER BY Diemcaonhat DESC, sv.Hoten";
            
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("masv", rs.getString("Masv"));
                row.put("hoten", rs.getString("Hoten"));
                row.put("ngaysinh", rs.getDate("Ngaysinh"));
                row.put("tenmonhoc", rs.getString("Tenmonhoc"));
                row.put("diemcaonhat", rs.getFloat("Diemcaonhat"));
                results.add(row);
            }
        } finally {
            closeResources(conn, stmt, rs);
        }
        return results;
    }
    
    public List<Diemthi> getDiemthiBySinhvien(String masv) throws SQLException, ClassNotFoundException {
        List<Diemthi> diemthiList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT * FROM Diemthi WHERE Masv = ?";
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, masv);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Diemthi dt = new Diemthi();
                dt.setMamon(rs.getString("Mamon"));
                dt.setMasv(rs.getString("Masv"));
                dt.setDiemlan1(rs.getFloat("Diemlan1"));
                dt.setDiemlan2(rs.getFloat("Diemlan2"));
                diemthiList.add(dt);
            }
        } finally {
            closeResources(conn, stmt, rs);
        }
        return diemthiList;
    }
    
    public void saveDiemthi(Diemthi diemthi) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            String sql = "INSERT INTO Diemthi (Mamon, Masv, Diemlan1, Diemlan2) " +
                        "VALUES (?, ?, ?, ?) " +
                        "ON DUPLICATE KEY UPDATE Diemlan1 = ?, Diemlan2 = ?";
            
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, diemthi.getMamon());
            stmt.setString(2, diemthi.getMasv());
            stmt.setFloat(3, diemthi.getDiemlan1());
            stmt.setFloat(4, diemthi.getDiemlan2());
            stmt.setFloat(5, diemthi.getDiemlan1());
            stmt.setFloat(6, diemthi.getDiemlan2());
            
            stmt.executeUpdate();
        } finally {
            closeResources(conn, stmt, null);
        }
    }
}