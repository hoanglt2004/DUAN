// DeleteServlet.java
package controller;

import dao.SinhvienDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String masv = request.getParameter("masv");

        try {
            // Sử dụng SinhvienDAO để xóa sinh viên
            SinhvienDAO sinhvienDAO = new SinhvienDAO();
            sinhvienDAO.deleteSinhvien(masv);
            
            response.sendRedirect("ListServlet");
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }
}