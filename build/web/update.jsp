<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cập nhật Sinh viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style/style.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Cập nhật thông tin sinh viên</h2>
        <form action="UpdateServlet" method="post">
            <div class="form-group">
                <label>Mã SV:</label>
                <input type="text" name="masv" class="form-control" value="${sinhvien.masv}" readonly>
            </div>
            <div class="form-group">
                <label>Họ tên:</label>
                <input type="text" name="hoten" class="form-control" value="${sinhvien.hoten}" required>
            </div>
            <div class="form-group">
                <label>Ngày sinh:</label>
                <input type="date" name="ngaysinh" class="form-control" value="${sinhvien.ngaysinh}" required>
            </div>
            <div class="form-group">
                <label>Giới tính:</label>
                <select name="gioitinh" class="form-control">
                    <option value="M" ${sinhvien.gioitinh == 'M' ? 'selected' : ''}>Nam</option>
                    <option value="F" ${sinhvien.gioitinh == 'F' ? 'selected' : ''}>Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label>Mã lớp:</label>
                <input type="text" name="malop" class="form-control" value="${sinhvien.malop}" required>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="ListServlet" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>