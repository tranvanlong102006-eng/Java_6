CREATE
DATABASE ASMGD_1;

USE
ASMGD_1;

CREATE TABLE KhachHang
(

    id             INT IDENTITY PRIMARY KEY,
    ma_khach_hang  VARCHAR,
    ten_khach_hang NVARCHAR,
    so_dien_thoai  INT,
    dia_chi        NVARCHAR,
    diem_tich_luy  FLOAT,
    danh_gia       FLOAT,
);

CREATE TABLE NhanVien
(

    id            INT IDENTITY PRIMARY KEY,
    ma_nhan_vien  VARCHAR,
    ten_nhan_vien NVARCHAR,
    so_dien_thoai INT,
    email         VARCHAR,
    ngay_sinh     DATE,
    dia_chi       NVARCHAR,
    mat_khau      VARCHAR,

);

CREATE TABLE ChucVu
(

    id          INT IDENTITY PRIMARY KEY,
    ma_chuc_vu  VARCHAR,
    ten_chuc_vu NVARCHAR,
    tien_luong  FLOAT,


);

CREATE TABLE SanPham
(
);

CREATE TABLE ThuocTinh
(
);

CREATE TABLE MauSac
(
);

CREATE TABLE ThuongHieu
(
);
