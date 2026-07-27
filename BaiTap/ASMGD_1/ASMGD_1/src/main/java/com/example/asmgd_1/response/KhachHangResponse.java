package com.example.asmgd_1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class KhachHangResponse {

    private Integer id;

    private String maKhachHang;

    private String tenKhachHang;

    private Boolean gioiTinh;

    private Integer soDienThoai;

    private String ngaySinh;

    private String diaChi;

    private float danhGia;

    private String matKhau;
}
