-- Chèn dữ liệu mẫu vào bảng Sinhvien
INSERT INTO Sinhvien VALUES
('SV001', 'Nguyễn Văn A', '2001-01-01', 'M', 'L01'),
('SV002', 'Trần Thị B', '2001-02-02', 'F', 'L01'),
('SV003', 'Lê Văn C', '2002-03-03', 'M', 'L02'),
('SV004', 'Phạm Thị D', '2001-04-04', 'F', 'L02'),
('SV005', 'Đỗ Minh E', '2000-05-05', 'M', 'L03');

-- Chèn dữ liệu mẫu vào bảng Monhoc
INSERT INTO Monhoc VALUES
('TTNT', 'Trí tuệ nhân tạo', 3),
('CS', 'Cấu trúc dữ liệu và giải thuật', 3),
('HDH', 'Hệ điều hành', 3),
('CSDL', 'Cơ sở dữ liệu', 3),
('KTLT', 'Kỹ thuật lập trình', 3);

-- Chèn dữ liệu mẫu vào bảng Diemthi
INSERT INTO Diemthi VALUES
('TTNT', 'SV001', 8.5, 9.0),
('TTNT', 'SV002', 7.0, 8.5),
('CS', 'SV003', 7.5, 8.0),
('HDH', 'SV004', 8.0, 8.5),
('CSDL', 'SV005', 6.5, 7.0);