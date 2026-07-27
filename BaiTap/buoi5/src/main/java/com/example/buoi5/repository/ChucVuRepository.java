package com.example.buoi5.repository;

import com.example.buoi5.entity.ChucVu;
import com.example.buoi5.response.ChucVuResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Integer> {

    @Query("""
            select new com.example.buoi5.response.ChucVuResponse(
            cv.id,
            cv.tenChucVu)
            from ChucVu cv
            """)
    List<ChucVuResponse> getAll();
}
