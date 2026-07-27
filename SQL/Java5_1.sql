CREATE
DATABASE SOF302201;
GO
USE SOF302201;
GO

-- Tạo bảng benh_vien
CREATE TABLE benh_vien
(
    id            INT IDENTITY(1,1) PRIMARY KEY,
    ten_benh_vien NVARCHAR(100) NOT NULL,
    dia_chi       NVARCHAR(255) NOT NULL
);
GO

-- Thêm dữ liệu vào bảng benh_vien
INSERT INTO benh_vien (ten_benh_vien, dia_chi)
VALUES 
    ('bach_mai_hospital', N'Số 78 Giải Phóng, Đống Đa, Hà Nội'),
    ('cho_ray_hospital', N'Số 201B Nguyễn Chí Thanh, Quận 5, TP.HCM'),
    ('viet_duc_hospital', N'Số 40 Tràng Thi, Hoàn Kiếm, Hà Nội');
GO

-- Tạo bảng bac_si
CREATE TABLE bac_si
(
    id           INT IDENTITY(1,1) PRIMARY KEY,
    ten_bac_si   NVARCHAR(100) NOT NULL,
    tuoi         INT NOT NULL,
    gioi_tinh    BIT NOT NULL,
    benh_vien_id INT NOT NULL,
    FOREIGN KEY (benh_vien_id) REFERENCES benh_vien (id)
);
GO

-- Thêm dữ liệu vào bảng bac_si
INSERT INTO bac_si (ten_bac_si, tuoi, gioi_tinh, benh_vien_id)
VALUES 
    ('nguyen_thanh_hai', 42, 1, 1),
    ('tran_kim_loan', 38, 0, 1),
    ('le_minh_tuan', 35, 1, 2),
    ('pham_thu_huong', 29, 0, 2),
    ('hoang_duc_anh', 50, 1, 3);
GO


CREATE TABLE sinh_vien
(
    id        int IDENTITY PRIMARY KEY NOT NULL,
    ma        VARCHAR(100),
    ten       VARCHAR(100) NULL,
    tuoi      BIGINT NULL,
    dia_chi   VARCHAR(100) NULL,
    gioi_tinh BIT NULL,
    lop_id    int NULL,
)
    GO
CREATE TABLE lop
(
    id  int IDENTITY PRIMARY KEY NOT NULL,
    ma  VARCHAR(100),
    ten VARCHAR(100) NULL,
) GO
INSERT INTO lop (ma, ten) 
VALUES 
('L01', 'Lớp Công Nghệ Thông Tin 1'),
('L02', 'Lớp Công Nghệ Thông Tin 2'),
('L03', 'Lớp Kế Toán 1');
GO
INSERT INTO sinh_vien (ma, ten, tuoi, dia_chi, gioi_tinh, lop_id) 
VALUES 
('SV001', 'Nguyễn Văn A', 20, 'Hà Nội', 1, 1),
('SV002', 'Trần Thị B', 22, 'Hồ Chí Minh', 0, 2),
('SV003', 'Phạm Văn C', 21, 'Đà Nẵng', 1, 1),
('SV004', 'Lê Thị D', 23, 'Hải Phòng', 0, 3),
('SV005', 'Ngô Văn E', 19, 'Cần Thơ', 1, 1);

-- Tạo bảng lớp học
CREATE TABLE lop_hoc
(
    id      INT IDENTITY(1,1) PRIMARY KEY,
    ten_lop NVARCHAR(50) NOT NULL,
    khoi    INT NOT NULL,
    si_so   INT DEFAULT 0
);
GO

-- Thêm dữ liệu vào bảng lớp học
INSERT INTO lop_hoc (ten_lop, khoi, si_so)
VALUES 
    (N'10A1', 10, 35),
    (N'10A2', 10, 38),
    (N'11B1', 11, 32),
    (N'12C1', 12, 30);
GO

-- Tạo bảng học sinh (5 trường, có khóa ngoại)
CREATE TABLE hoc_sinh
(
    id         INT IDENTITY(1,1) PRIMARY KEY,
    ho_ten     NVARCHAR(100) NOT NULL,
    gioi_tinh  BIT NOT NULL,
    dia_chi    NVARCHAR(200),
    lop_hoc_id INT NOT NULL,
    FOREIGN KEY (lop_hoc_id) REFERENCES lop_hoc (id)
);
GO

-- Thêm dữ liệu vào bảng học sinh
INSERT INTO hoc_sinh (ho_ten, gioi_tinh, dia_chi, lop_hoc_id)
VALUES 
    (N'Nguyễn Văn An', 1, N'Hà Nội', 1),
    (N'Trần Thị Bình', 0, N'Hải Phòng', 1),
    (N'Lê Hoàng Cường', 1, N'Đà Nẵng', 2),
    (N'Phạm Minh Đức', 1, N'TP.HCM', 3),
    (N'Hoàng Thị Lan', 0, N'Hà Nội', 4);
GO