package com.example.asmgd_1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class HoaDonResponse {

    private Integer id;

    private String maHoaDon;

    private String tenHoaDon;

    private String tenKhachHang;

    private String tenNhanVien;

    private String tenHoaDonChiTiet;

    private String ngayTao;

    private Boolean trangThai;
}
