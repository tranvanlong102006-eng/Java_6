package com.example.asmgd_1.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class SanPhamRequest {

    private String maSanPham;

    private String tenSanPham;
}
