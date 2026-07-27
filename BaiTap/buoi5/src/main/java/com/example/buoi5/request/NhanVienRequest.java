package com.example.buoi5.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class NhanVienRequest {

    @NotBlank(message = "Mã nhân viên không được để trống !")
    private String maNhanVien;

    @NotBlank(message = "Tên nhân viên không được để trống !")
    private String tenNhanVien;

    @NotNull(message = "Giới tính không được để trống !")
    private Boolean gioiTinh;

    @NotNull(message = "Chức vụ không được để trống !")
    private Integer chucVuId;
}
