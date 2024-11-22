// AddServlet.java
package controller;

import dao.SinhvienDAO;
import model.Sinhvien;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String masv = request.getParameter("masv");
            String hoten = request.getParameter("hoten");
            Date ngaysinh = Date.valueOf(request.getParameter("ngaysinh"));
            String gioitinh = request.getParameter("gioitinh");
            String malop = request.getParameter("malop");
            
            // Tạo đối tượng Sinhvien
            Sinhvien sv = new Sinhvien();
            sv.setMasv(masv);
            sv.setHoten(hoten);
            sv.setNgaysinh(ngaysinh);
            sv.setGioitinh(gioitinh);
            sv.setMalop(malop);
            
            // Sử dụng SinhvienDAO để lưu sinh viên
            SinhvienDAO sinhvienDAO = new SinhvienDAO();
            sinhvienDAO.saveSinhvien(sv);
            
            response.sendRedirect("ListServlet");
            
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
}