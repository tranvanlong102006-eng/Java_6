package com.example.asmgd_1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SanPhamResponse {

    private Integer id;

    private String maSanPham;

    private String tenSanPham;
}
