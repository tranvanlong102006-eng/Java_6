package com.example.buoi5.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "NhanVien")
@ToString
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ma")
    private String maNhanVien;

    @Column(name = "Ten")
    private String tenNhanVien;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name = "IdCV", referencedColumnName = "Id")
    private ChucVu chucVu;
}
