package com.example.asmgd_1.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class HoaDonChiTietRequest {

    private String maHoaDonChiTiet;

    private String tenHoaDonChiTiet;

    private Integer soLuong;

    private Double donGia;

    private Integer sanPhamChiTietId;

    private Integer phieuGiamGiaId;
}
