package com.example.java6.buoi1.repository;

import com.example.java6.buoi1.entity.Category;
import com.example.java6.buoi1.response.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("""
            select new com.example.java6.buoi1.response.CategoryResponse(
            c.id,
            c.categoryCode,
            c.categoryName
            )
            from Category c
            """)
    List<CategoryResponse> getAll();
}
