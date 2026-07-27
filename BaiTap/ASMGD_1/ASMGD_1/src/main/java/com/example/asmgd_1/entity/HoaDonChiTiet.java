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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_hoa_don_chi_tiet")
    private String maHoaDonChiTiet;

    @Column(name = "ten_hoa_don_chi_tiet")
    private String tenHoaDonChiTiet;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "don_gia")
    private Double donGia;

    @ManyToOne
    @JoinColumn(name = "san_pham_chi_tiet_id", referencedColumnName = "id")
    private SanPhamChiTiet sanPhamChiTiet;

    @ManyToOne
    @JoinColumn(name = "phieu_giam_gia_id", referencedColumnName = "id")
    private PhieuGiamGia phieuGiamGia;
}
