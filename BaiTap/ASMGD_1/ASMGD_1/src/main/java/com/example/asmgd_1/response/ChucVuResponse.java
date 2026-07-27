package com.example.asmgd_1.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ChucVuResponse {

    private Integer id;

    private String maChucVu;

    private String tenChucVu;
}
