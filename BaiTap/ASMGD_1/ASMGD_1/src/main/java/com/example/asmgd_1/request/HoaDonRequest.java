package com.example.asmgd_1.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class HoaDonRequest {

    private String maHoaDon;

    private String tenHoaDon;

    private String ngayTao;

    private Boolean trangThai;

    private Integer khachHangId;

    private Integer nhanVienId;

    private Integer hoaDonChiTietId;
}
