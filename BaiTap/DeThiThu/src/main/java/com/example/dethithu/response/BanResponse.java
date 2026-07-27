package com.example.dethithu.response;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BanResponse {

    private Integer id;

    private String maBan;

    private String tenBan;

    private LocalDate ngaySinh;

    private String maMoiQuanHe;

    private String tenMoiQuanHe;
}
