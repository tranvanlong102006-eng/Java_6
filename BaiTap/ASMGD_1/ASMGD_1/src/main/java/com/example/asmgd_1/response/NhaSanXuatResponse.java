package com.example.asmgd_1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class NhaSanXuatResponse {

    private Integer id;

    private String maNhaSanXuat;

    private String tenNhaSanXuat;
}
