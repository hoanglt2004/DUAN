<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý sinh viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style/style.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Danh sách sinh viên</h2>
        
        <!-- Thông báo -->
        <c:if test="${not empty param.message}">
            <div class="alert alert-success">${param.message}</div>
        </c:if>
        
        <div class="mb-3">
            <a href="add.jsp" class="btn btn-primary">Add</a>
            <a href="FindServlet" class="btn btn-info">Find</a>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th>Mã SV</th>
                    <th>Họ tên</th>
                    <th>Ngày sinh</th>
                    <th>Giới tính</th>
                    <th>Mã lớp</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sv" items="${listSinhvien}">
                    <tr>
                        <td>${sv.masv}</td>
                        <td>${sv.hoten}</td>
                        <td>${sv.ngaysinh}</td>
                        <td>${sv.gioitinh}</td>
                        <td>${sv.malop}</td>
                        <td>
                            <a href="UpdateServlet?masv=${sv.masv}" class="btn btn-warning btn-sm">Update</a>
                            <a href="DeleteServlet?masv=${sv.masv}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>