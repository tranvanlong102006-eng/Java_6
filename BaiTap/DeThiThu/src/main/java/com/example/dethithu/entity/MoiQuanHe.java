package com.example.dethithu.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "moi_quan_he")
@ToString
public class MoiQuanHe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma")
    private String maMoiQuanHe;

    @Column(name = "loai_quan_he")
    private String tenMoiQuanHe;
}
