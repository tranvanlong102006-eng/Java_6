package com.example.asmgd_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "KhachHang")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_khach_hang")
    private String maKhachHang;

    @Column(name = "ten_khach_hang")
    private String tenKhachHang;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "so_dien_thoai")
    private Integer soDienThoai;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "danh_gia")
    private float danhGia;

    @Column(name = "mat_khau")
    private String matKhau;
}
