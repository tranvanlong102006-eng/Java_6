package com.example.asmgd_1.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class NhanVienRequest {

    private String maNhanVien;

    private String tenNhanVien;

    private Boolean gioiTinh;

    private Integer soDienThoai;

    private String email;

    private String ngaySinh;

    private String diaChi;

    private String matKhau;

    private Integer chucVuId;
}
