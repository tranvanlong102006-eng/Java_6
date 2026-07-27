package com.example.asmgd_1.repository;

import com.example.asmgd_1.entity.NhanVien;
import com.example.asmgd_1.response.KhachHangResponse;
import com.example.asmgd_1.response.NhanVienResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    @Query("""
            SELECT NEW com.example.asmgd_1.response.NhanVienResponse(
            nv.id,
            nv.maNhanVien,
            nv.tenNhanVien,
            cv.tenChucVu,
            nv.gioiTinh,
            nv.soDienThoai,
            nv.email,
            nv.ngaySinh,
            nv.diaChi,
            nv.matKhau
            )
            FROM 
            NhanVien nv
            JOIN ChucVu cv ON nv.chucVu.id = cv.id
            WHERE nv.tenNhanVien LIKE %:ten%
            """)
    List<NhanVienResponse> searchNhanVien(@Param("ten") String tenNhanVien);
}
