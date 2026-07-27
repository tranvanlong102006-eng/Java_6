package com.example.buoi5.response;

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

    private Boolean gioiTinh;

    private String tenChucVu;
}
