package com.example.asmgd_1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class HoaDonChiTietResponse {

    private Integer id;

    private String maHoaDonChiTiet;

    private String tenHoaDonChiTiet;

    private String tenSanPhamChiTiet;

    private String tenPhieuGiamGia;

    private Integer soLuong;

    private Double donGia;
}
