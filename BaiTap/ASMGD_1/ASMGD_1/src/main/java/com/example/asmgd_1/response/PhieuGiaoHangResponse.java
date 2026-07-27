package com.example.asmgd_1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PhieuGiaoHangResponse {

    private Integer id;

    private String maPhieuGiao;

    private String tenHoaDon;

    private String tenDonViVanChuyen;

    private String ngayDuKien;

    private String ngayThucTe;

    private Integer phiShip;

    private String diaChi;

    private String tenNguoiNhan;

    private Integer soDienThoai;

    private String ghiChu;
}
