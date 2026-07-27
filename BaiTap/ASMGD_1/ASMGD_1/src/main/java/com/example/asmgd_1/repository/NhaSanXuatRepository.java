package com.example.asmgd_1.repository;

import com.example.asmgd_1.entity.NhaSanXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaSanXuatRepository extends JpaRepository<NhaSanXuat, Integer> {
}
