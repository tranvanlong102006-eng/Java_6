package com.example.asmgd_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "NhaSanXuat")
public class NhaSanXuat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_nha_san_xuat")
    private String maNhaSanXuat;

    @Column(name = "ten_nha_san_xuat")
    private String tenNhaSanXuat;
}
