package com.example.java6.buoi1.repository;

import com.example.java6.buoi1.entity.Product;
import com.example.java6.buoi1.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("""
            select new com.example.java6.buoi1.response.ProductResponse(
            p.id,
            p.productCode,
            p.productName,
            p.category.categoryCode,
            p.category.categoryName,
            p.price,
            p.description)
            from Product p
            """)
    List<ProductResponse> getAll();

    @Query("""
            select new com.example.java6.buoi1.response.ProductResponse(
            p.id,
            p.productCode,
            p.productName,
            p.category.categoryCode,
            p.category.categoryName,
            p.price,
            p.description)
            from Product p
            where p.id = ?1
            """)
    ProductResponse detail(Integer id);

    @Query("""
            select new com.example.java6.buoi1.response.ProductResponse(
            p.id,
            p.productCode,
            p.productName,
            p.category.categoryCode,
            p.category.categoryName,
            p.price,
            p.description)
            from Product p
            """)
    Page<ProductResponse> paging(Pageable pageable);

    @Query("""
            select new com.example.java6.buoi1.response.ProductResponse(
            p.id,
            p.productCode,
            p.productName,
            p.category.categoryCode,
            p.category.categoryName,
            p.price,
            p.description)
            from Product p
            where p.productCode like %:code%
            """)
    List<ProductResponse> search(@Param("code") String code);
}
