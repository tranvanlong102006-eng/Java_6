package com.example.dethithu.repository;

import com.example.dethithu.entity.Ban;
import com.example.dethithu.response.BanResponse;
import com.example.dethithu.response.MoiQuanHeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BanRepository extends JpaRepository<Ban, Integer> {

    @Query("""
            select new com.example.dethithu.response.BanResponse(
            b.id,
            b.maBan,
            b.tenBan,
            b.ngaySinh,
            b.moiQuanHe.maMoiQuanHe,
            b.moiQuanHe.tenMoiQuanHe)
            from Ban b  
            """)
    List<BanResponse> getAll();

    @Query("""
            select new com.example.dethithu.response.BanResponse(
            b.id,
            b.maBan,
            b.tenBan,
            b.ngaySinh,
            b.moiQuanHe.maMoiQuanHe,
            b.moiQuanHe.tenMoiQuanHe)
            from Ban b  
            where b.id = ?1
            """)
    BanResponse detail(Integer id);

    @Query("""
            select new com.example.dethithu.response.BanResponse(
            b.id,
            b.maBan,
            b.tenBan,
            b.ngaySinh,
            b.moiQuanHe.maMoiQuanHe,
            b.moiQuanHe.tenMoiQuanHe)
            from Ban b  
            """)
    Page<BanResponse> paging(Pageable pageable);
}
