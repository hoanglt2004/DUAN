// ListServlet.java
package controller;

import model.Sinhvien;
import dao.SinhvienDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    private final SinhvienDAO sinhvienDAO = new SinhvienDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Sinhvien> listSinhvien = sinhvienDAO.getAllSinhvien();
            
            // Sắp xếp danh sách sinh viên theo masv từ bé đến lớn
            Collections.sort(listSinhvien, (Sinhvien sv1, Sinhvien sv2) -> sv1.getMasv().compareTo(sv2.getMasv()));
            
            request.setAttribute("listSinhvien", listSinhvien);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}