package com.example.asmgd_1.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class KhachHangRequest {

    private String maKhachHang;

    private String tenKhachHang;

    private Boolean gioiTinh;

    private Integer soDienThoai;

    private String ngaySinh;

    private String diaChi;

    private float danhGia;

    private String matKhau;
}
