<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sinh viên TTNT</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style/style.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Danh sách sinh viên có điểm TTNT >= 8.5</h2>
        
        <c:if test="${empty results}">
            <div class="alert alert-warning">Không có sinh viên nào đạt yêu cầu.</div>
        </c:if>
        
        <table class="table">
            <thead>
                <tr>
                    <th>Mã SV</th>
                    <th>Họ tên</th>
                    <th>Ngày sinh</th>
                    <th>Tên môn học</th>
                    <th>Điểm cao nhất</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="result" items="${results}">
                    <tr>
                        <td>${result.masv}</td>
                        <td>${result.hoten}</td>
                        <td>${result.ngaysinh}</td>
                        <td>${result.tenmonhoc}</td>
                        <td>${result.diemcaonhat}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="ListServlet" class="btn btn-primary">Back to List</a>
    </div>
</body>
</html>