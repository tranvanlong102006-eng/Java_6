package com.example.asmgd_1.repository;

import com.example.asmgd_1.entity.HoaDon;
import com.example.asmgd_1.response.HoaDonResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonReposioty extends JpaRepository<HoaDon, Integer> {

    @Query("""
            SELECT NEW com.example.asmgd_1.response.HoaDonResponse(
            hd.id,
            hd.maHoaDon,
            hd.tenHoaDon,
            kh.tenKhachHang,
            nv.tenNhanVien,
            hdct.tenHoaDonChiTiet,
            hd.ngayTao,
            hd.trangThai
            )
            FROM HoaDon hd
            JOIN KhachHang kh ON hd.khachHang.id = kh.id
            JOIN NhanVien nv ON hd.nhanVien.id = nv.id
            JOIN HoaDonChiTiet hdct ON hd.hoaDonChiTiet.id = hdct.id
            WHERE hd.tenHoaDon LIKE %:ten%
            """)
    List<HoaDonResponse> searchHoaDon(@Param("ten") String tenHoaDon);
}
