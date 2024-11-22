// SinhvienDAO.java
package dao;

import model.Sinhvien;
import java.sql.*;
import java.util.*;

public class SinhvienDAO extends BaseDAO {
    
    public List<Sinhvien> getAllSinhvien() throws SQLException, ClassNotFoundException {
        List<Sinhvien> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM Sinhvien ORDER BY Hoten");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                list.add(mapResultSetToSinhvien(rs));
            }
        } finally {
            closeResources(conn, stmt, rs);
        }
        return list;
    }
    
    public Sinhvien getSinhvienByMasv(String masv) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM Sinhvien WHERE Masv = ?");
            stmt.setString(1, masv);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapResultSetToSinhvien(rs);
            }
            return null;
        } finally {
            closeResources(conn, stmt, rs);
        }
    }
    
    public void saveSinhvien(Sinhvien sv) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            String sql = "INSERT INTO Sinhvien (Masv, Hoten, Ngaysinh, Gioitinh, Malop) " +
                        "VALUES (?, ?, ?, ?, ?) " +
                        "ON DUPLICATE KEY UPDATE Hoten = ?, Ngaysinh = ?, Gioitinh = ?, Malop = ?";
            
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            
            // Set parameters for INSERT
            stmt.setString(1, sv.getMasv());
            stmt.setString(2, sv.getHoten());
            stmt.setDate(3, new java.sql.Date(sv.getNgaysinh().getTime()));
            stmt.setString(4, sv.getGioitinh());
            stmt.setString(5, sv.getMalop());
            
            // Set parameters for UPDATE
            stmt.setString(6, sv.getHoten());
            stmt.setDate(7, new java.sql.Date(sv.getNgaysinh().getTime()));
            stmt.setString(8, sv.getGioitinh());
            stmt.setString(9, sv.getMalop());
            
            stmt.executeUpdate();
        } finally {
            closeResources(conn, stmt, null);
        }
    }
    
    public void deleteSinhvien(String masv) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            
            // Xóa điểm thi trước
            stmt = conn.prepareStatement("DELETE FROM Diemthi WHERE Masv = ?");
            stmt.setString(1, masv);
            stmt.executeUpdate();
            
            // Xóa sinh viên
            stmt = conn.prepareStatement("DELETE FROM Sinhvien WHERE Masv = ?");
            stmt.setString(1, masv);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected == 0) {
                throw new SQLException("Student not found with ID: " + masv);
            }
            
            conn.commit();
        } catch (SQLException e) {
            rollbackTransaction(conn);
            throw e;
        } finally {
            closeResources(conn, stmt, null);
        }
    }
    
    private Sinhvien mapResultSetToSinhvien(ResultSet rs) throws SQLException {
        Sinhvien sv = new Sinhvien();
        sv.setMasv(rs.getString("Masv"));
        sv.setHoten(rs.getString("Hoten"));
        sv.setNgaysinh(rs.getDate("Ngaysinh"));
        sv.setGioitinh(rs.getString("Gioitinh"));
        sv.setMalop(rs.getString("Malop"));
        return sv;
    }
}
