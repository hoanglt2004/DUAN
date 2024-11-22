// FindServlet.java
package controller;

import dao.DiemthiDAO;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
    private final DiemthiDAO diemthiDAO = new DiemthiDAO();
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Map<String, Object>> results = diemthiDAO.getSinhvienTTNT();
            request.setAttribute("results", results);
            request.getRequestDispatcher("showTTNT.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FindServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}