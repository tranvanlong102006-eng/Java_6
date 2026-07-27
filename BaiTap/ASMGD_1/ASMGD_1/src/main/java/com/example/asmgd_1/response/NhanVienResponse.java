package com.example.asmgd_1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class NhanVienResponse {

    private Integer id;

    private String maNhanVien;

    private String tenNhanVien;

    private String tenChucVu;

    private Boolean gioiTinh;

    private Integer soDienThoai;

    private String email;

    private String ngaySinh;

    private String diaChi;

    private String matKhau;

}
