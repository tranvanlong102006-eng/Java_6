package com.example.dethithu.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BanRequest {

    @NotBlank(message = "Ma ban khong duoc de trong!")
    private String maBan;

    @NotBlank(message = "Ten ban khong duoc de trong!")
    private String tenBan;

    @NotNull(message = "Ngay sinh khong duoc de trong!")
    private LocalDate ngaySinh;

    @NotNull(message = "Moi quan he khong duoc de trong!")
    private Integer moiQuanHeId;


}
