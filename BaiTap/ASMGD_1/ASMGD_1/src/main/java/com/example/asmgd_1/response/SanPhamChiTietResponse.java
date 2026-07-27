package com.example.asmgd_1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SanPhamChiTietResponse {

    private Integer id;

    private String maSanPhamChiTiet;

    private String tenSanPhamChiTiet;

    private String tenSanPham;

    private String tenMauSac;

    private String tenThuongHieu;

    private String tenNhaSanXuat;

    private String moTa;

    private Integer soLuongTon;

    private Double giaNhap;

    private Double giaBan;
}
