-- Tạo cơ sở dữ liệu
CREATE DATABASE QLD_C061;
USE QLD_C061;

-- Tạo bảng Sinhvien
CREATE TABLE Sinhvien (
    Masv VARCHAR(10) PRIMARY KEY,
    Hoten VARCHAR(50) NOT NULL,
    Ngaysinh DATE,
    Gioitinh CHAR(1),
    Malop VARCHAR(10)
);

-- Tạo bảng Monhoc
CREATE TABLE Monhoc (
    Mamon VARCHAR(10) PRIMARY KEY,
    Tenmonhoc VARCHAR(50) NOT NULL,
    Sotinchi INT
);

-- Tạo bảng Diemthi
CREATE TABLE Diemthi (
    Mamon VARCHAR(10),
    Masv VARCHAR(10),
    Diemlan1 FLOAT,
    Diemlan2 FLOAT,
    PRIMARY KEY (Mamon, Masv),
    FOREIGN KEY (Mamon) REFERENCES Monhoc(Mamon),
    FOREIGN KEY (Masv) REFERENCES Sinhvien(Masv)
);