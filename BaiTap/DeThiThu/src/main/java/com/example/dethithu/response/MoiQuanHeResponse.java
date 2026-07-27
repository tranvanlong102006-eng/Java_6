package com.example.dethithu.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class MoiQuanHeResponse {

    private Integer id;

    private String maMoiQuanHe;

    private String tenMoiQuanHe;
}
