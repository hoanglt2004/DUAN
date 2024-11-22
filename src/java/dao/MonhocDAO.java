// MonhocDAO.java
package dao;

import model.Monhoc;
import java.sql.*;
import java.util.*;

public class MonhocDAO extends BaseDAO {
    
    public List<Monhoc> getAllMonhoc() throws SQLException, ClassNotFoundException {
        List<Monhoc> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM Monhoc ORDER BY Tenmonhoc");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Monhoc mh = new Monhoc();
                mh.setMamon(rs.getString("Mamon"));
                mh.setTenmonhoc(rs.getString("Tenmonhoc"));
                mh.setSotinchi(rs.getInt("Sotinchi"));
                list.add(mh);
            }
        } finally {
            closeResources(conn, stmt, rs);
        }
        return list;
    }
    
    public Monhoc getMonhocByMa(String mamon) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM Monhoc WHERE Mamon = ?");
            stmt.setString(1, mamon);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                Monhoc mh = new Monhoc();
                mh.setMamon(rs.getString("Mamon"));
                mh.setTenmonhoc(rs.getString("Tenmonhoc"));
                mh.setSotinchi(rs.getInt("Sotinchi"));
                return mh;
            }
            return null;
        } finally {
            closeResources(conn, stmt, rs);
        }
    }
    
    public void saveMonhoc(Monhoc monhoc) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            String sql = "INSERT INTO Monhoc (Mamon, Tenmonhoc, Sotinchi) " +
                        "VALUES (?, ?, ?) " +
                        "ON DUPLICATE KEY UPDATE Tenmonhoc = ?, Sotinchi = ?";
            
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, monhoc.getMamon());
            stmt.setString(2, monhoc.getTenmonhoc());
            stmt.setInt(3, monhoc.getSotinchi());
            stmt.setString(4, monhoc.getTenmonhoc());
            stmt.setInt(5, monhoc.getSotinchi());
            
            stmt.executeUpdate();
        } finally {
            closeResources(conn, stmt, null);
        }
    }
    
    public void deleteMonhoc(String mamon) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            
            // Xóa điểm thi liên quan
            stmt = conn.prepareStatement("DELETE FROM Diemthi WHERE Mamon = ?");
            stmt.setString(1, mamon);
            stmt.executeUpdate();
            
            // Xóa môn học
            stmt = conn.prepareStatement("DELETE FROM Monhoc WHERE Mamon = ?");
            stmt.setString(1, mamon);
            stmt.executeUpdate();
            
            conn.commit();
        } catch (SQLException e) {
            rollbackTransaction(conn);
            throw e;
        } finally {
            closeResources(conn, stmt, null);
        }
    }
}