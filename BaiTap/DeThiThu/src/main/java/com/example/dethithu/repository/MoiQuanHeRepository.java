package com.example.dethithu.repository;

import com.example.dethithu.entity.MoiQuanHe;
import com.example.dethithu.response.MoiQuanHeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoiQuanHeRepository extends JpaRepository<MoiQuanHe, Integer> {

    @Query("""
            select new com.example.dethithu.response.MoiQuanHeResponse(
            mqh.id,
            mqh.maMoiQuanHe,
            mqh.tenMoiQuanHe)
            from MoiQuanHe mqh
            """)
    List<MoiQuanHeResponse> getAll();
}
