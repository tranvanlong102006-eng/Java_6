package com.example.dethithu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ban")
@ToString
public class Ban {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma")
    private String maBan;

    @Column(name = "ho_ten")
    private String tenBan;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @ManyToOne
    @JoinColumn(name = "moi_quan_he_id", referencedColumnName = "id")
    private MoiQuanHe moiQuanHe;
}
