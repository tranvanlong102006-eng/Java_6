package com.example.asmgd_1.repository;

import com.example.asmgd_1.entity.KhachHang;
import com.example.asmgd_1.response.KhachHangResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {

    @Query("""
            SELECT NEW com.example.asmgd_1.response.KhachHangResponse(
                kh.id, kh.maKhachHang, kh.tenKhachHang, kh.gioiTinh, 
                kh.soDienThoai, kh.ngaySinh, kh.diaChi, kh.danhGia, kh.matKhau
            )
            FROM KhachHang kh
            WHERE kh.tenKhachHang LIKE %:ten% 
            """)
    List<KhachHangResponse> searchKhachHang(@Param("ten") String tenKhachHang);
}
