// UpdateServlet.java
package controller;

import dao.SinhvienDAO;
import model.Sinhvien;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String masv = request.getParameter("masv");
            SinhvienDAO sinhvienDAO = new SinhvienDAO();
            Sinhvien sv = sinhvienDAO.getSinhvienByMasv(masv);
            
            if (sv != null) {
                request.setAttribute("sinhvien", sv);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } else {
                response.sendRedirect("ListServlet"); // Nếu sinh viên không tồn tại, chuyển hướng về danh sách
            }
            
        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
            throw new ServletException(e);
        }
    }
    
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
            
            // Sử dụng SinhvienDAO để cập nhật sinh viên
            SinhvienDAO sinhvienDAO = new SinhvienDAO();
            sinhvienDAO.saveSinhvien(sv); // Phương thức saveSinhvien cũng thực hiện cập nhật
            
            response.sendRedirect("ListServlet");
            
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
}