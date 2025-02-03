CREATE DATABASE SD_75;
GO
USE SD_75;
GO
CREATE TABLE nguoi_dung
(
    id           INT PRIMARY KEY IDENTITY,
    sdt          NVARCHAR(25),
    email        NVARCHAR(255),
    ho_ten       NVARCHAR(255),
    mat_khau     NVARCHAR(255),
    vai_tro      TINYINT CHECK (vai_tro IN (0, 1, 2)) DEFAULT 0, -- 0:customer, 1:staff, 2:admin
    trang_thai   BIT                                  DEFAULT 1, -- 0:inactive, 1:active
    refesh_token NVARCHAR(255)
)
GO

CREATE TABLE dia_chi
(
    id             INT PRIMARY KEY IDENTITY,
    id_nguoi_dung  INT FOREIGN KEY REFERENCES nguoi_dung (id),
    xa             NVARCHAR(255),
    huyen          NVARCHAR(255),
    tinh           NVARCHAR(255),
    dia_chi_cu_the NVARCHAR(255)
)
GO

CREATE TABLE danh_muc
(
    id           INT PRIMARY KEY IDENTITY,
    ten_danh_muc NVARCHAR(255),
    icon         NVARCHAR(255)
)
GO

CREATE TABLE san_pham
(
    id            INT PRIMARY KEY IDENTITY,
    id_danh_muc   INT FOREIGN KEY REFERENCES danh_muc (id),
    ma_san_pham   NVARCHAR(50),
    ten_san_pham  NVARCHAR(255),
    anh_dai_dien  NVARCHAR(255),
    gia_co_so     MONEY,
    can_nang      INT,
    mo_ta         NVARCHAR(400),
    thong_so_json NVARCHAR(MAX)
)
GO
CREATE TABLE hinh_anh
(
    id          INT PRIMARY KEY IDENTITY,
    id_san_pham INT FOREIGN KEY REFERENCES san_pham (id),
    url         NVARCHAR(255),
    public_id   NVARCHAR(20)
)
GO
CREATE TABLE chi_tiet_san_pham
(
    id            INT PRIMARY KEY IDENTITY,
    id_san_pham   INT FOREIGN KEY REFERENCES san_pham (id),
    sku           NVARCHAR(50) UNIQUE,
    mau_sac       NVARCHAR(50),
    bien_the_json NVARCHAR(MAX),
    gia_bien_the  MONEY,
    ton_kho       INT
)
GO

CREATE TABLE gio_hang
(
    id                   INT PRIMARY KEY IDENTITY,
    id_nguoi_dung        INT FOREIGN KEY REFERENCES nguoi_dung (id),
    id_chi_tiet_san_pham INT FOREIGN KEY REFERENCES chi_tiet_san_pham (id),
    so_luong             INT CHECK (so_luong > 0 AND so_luong <= 3)
)
GO

CREATE TABLE phieu_giam_gia
(
    id                         INT PRIMARY KEY IDENTITY,
    ma_phieu_giam_gia          NVARCHAR(50) UNIQUE,
    loai_giam_gia              TINYINT CHECK (loai_giam_gia IN (0, 1)), -- 0:phan tram, 1:so tien
    gia_tri_giam_gia           MONEY,
    so_luong                   INT,
    gia_tri_don_hang_toi_thieu MONEY,
    gia_tri_toi_da_giam_gia    MONEY,
    ngay_bat_dau               DATETIME2,
    ngay_ket_thuc              DATETIME2
)
GO

CREATE TABLE don_hang
(
    id                       INT PRIMARY KEY IDENTITY,
    id_nguoi_dung            INT FOREIGN KEY REFERENCES nguoi_dung (id),
    id_phieu_giam_gia        INT FOREIGN KEY REFERENCES phieu_giam_gia (id),
    ma_don_hang              NVARCHAR(50),
    tong_tien                MONEY,
    trang_thai               TINYINT CHECK (trang_thai IN (0, 1, 2, 3, 4, 5)),
    phuong_thuc_thanh_toan   TINYINT CHECK (phuong_thuc_thanh_toan IN (0, 1)),
    so_dien_thoai_nguoi_nhan NVARCHAR(25),
    dia_chi_giao_hang        NVARCHAR(1000),
    ngay_tao                 DATETIME2
)
GO

CREATE TABLE chi_tiet_don_hang
(
    id                   INT PRIMARY KEY IDENTITY,
    id_don_hang          INT FOREIGN KEY REFERENCES don_hang (id),
    id_chi_tiet_san_pham INT FOREIGN KEY REFERENCES chi_tiet_san_pham (id),
    so_luong             INT,
    gia_bien_the         MONEY
)
GO

CREATE TABLE hoa_don
(
    id            INT PRIMARY KEY IDENTITY,
    id_don_hang   INT FOREIGN KEY REFERENCES don_hang (id),
    ma_hoa_don    NVARCHAR(50),
    ngay_tao      DATETIME2,
    ngay_cap_nhat DATETIME2
)
GO

CREATE TABLE dot_khuyen_mai
(
    id                 INT PRIMARY KEY IDENTITY,
    ten_dot_khuyen_mai NVARCHAR(255),
    loai_giam_gia      TINYINT CHECK (loai_giam_gia IN (0, 1)),
    gia_tri_giam_gia   MONEY,
    ngay_bat_dau       DATETIME2,
    ngay_ket_thuc      DATETIME2
)
GO

CREATE TABLE chi_tiet_dot_khuyen_mai
(
    id                INT PRIMARY KEY IDENTITY,
    id_dot_khuyen_mai INT FOREIGN KEY REFERENCES dot_khuyen_mai (id),
    id_san_pham       INT FOREIGN KEY REFERENCES san_pham (id),
)
GO

CREATE TABLE danh_gia
(
    id            INT PRIMARY KEY IDENTITY,
    id_nguoi_dung INT FOREIGN KEY REFERENCES nguoi_dung (id),
    id_san_pham   INT FOREIGN KEY REFERENCES san_pham (id),
    diem          TINYINT CHECK (diem IN (1, 2, 3, 4, 5)),
    nhan_xet      NVARCHAR(500),
    ngay_tao      SMALLDATETIME
)
GO
CREATE TABLE tra_hang
(
    id                   INT PRIMARY KEY IDENTITY,
    id_chi_tiet_don_hang INT FOREIGN KEY REFERENCES chi_tiet_don_hang (id),
    so_luong_tra         INT,
    ly_do                NVARCHAR(255),
    trang_thai           TINYINT CHECK (trang_thai IN (0, 1, 2, 3)), -- 0:chờ xác nhận, 1:đã xác nhận, 2:đã trả, 3:đã từ chối
    tien_tra             MONEY,
    ngay_tao             DATETIME2,
    ngay_cap_nhat        DATETIME2

)
GO
CREATE TABLE hinh_anh_tra_hang
(
    id         INT PRIMARY KEY IDENTITY,
    id_doi_tra INT FOREIGN KEY REFERENCES tra_hang (id),
    url        NVARCHAR(255),
    public_id  NVARCHAR(20)
)
GO
CREATE TABLE thong_tin_hoan_tien_tra_hang
(
    id                      INT PRIMARY KEY IDENTITY,
    id_tra_hang             INT FOREIGN KEY REFERENCES tra_hang (id),
    ngan_hang_tra           NVARCHAR(255),
    stk_nguoi_tra           NVARCHAR(25),
    anh_chup_bill_hoan_tien NVARCHAR(255)
)


