package com.example.buoi5.repository;

import com.example.buoi5.entity.NhanVien;
import com.example.buoi5.response.NhanVienResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    @Query("""
            select new com.example.buoi5.response.NhanVienResponse(
            nv.id,
            nv.maNhanVien,
            nv.tenNhanVien,
            nv.gioiTinh,
            nv.chucVu.tenChucVu)
            from NhanVien nv
            """)
    List<NhanVienResponse> getAll();

    @Query("""
            select new com.example.buoi5.response.NhanVienResponse(
            nv.id,
            nv.maNhanVien,
            nv.tenNhanVien,
            nv.gioiTinh,
            nv.chucVu.tenChucVu)
            from NhanVien nv
            where nv.id = ?1
            """)
    NhanVienResponse detail(Integer id);


    @Query("""
            select new com.example.buoi5.response.NhanVienResponse(
            nv.id,
            nv.maNhanVien,
            nv.tenNhanVien,
            nv.gioiTinh,
            nv.chucVu.tenChucVu)
            from NhanVien nv
            """)
    Page<NhanVienResponse> paging(Pageable pageable);


    @Query("""
            select new com.example.buoi5.response.NhanVienResponse(
            nv.id,
            nv.maNhanVien,
            nv.tenNhanVien,
            nv.gioiTinh,
            nv.chucVu.tenChucVu)
            from NhanVien nv
            where nv.tenNhanVien like %:ten%
            """)
    List<NhanVienResponse> search(@Param("ten") String ten);
}
