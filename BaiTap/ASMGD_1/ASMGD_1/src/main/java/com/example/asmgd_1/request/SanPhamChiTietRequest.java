package com.example.asmgd_1.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SanPhamChiTietRequest {

    private String maSanPhamChiTiet;

    private String tenSanPhamChiTiet;

    private String moTa;

    private Integer soLuongTon;

    private Double giaNhap;

    private Double giaBan;

    private Integer sanPhamId;

    private Integer nhaSanXuatId;

    private Integer mauSacId;

    private Integer thuongHieuId;
}
