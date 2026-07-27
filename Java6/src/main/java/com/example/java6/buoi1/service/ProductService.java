package com.example.java6.buoi1.service;

import com.example.java6.buoi1.entity.Category;
import com.example.java6.buoi1.entity.Product;
import com.example.java6.buoi1.repository.CategoryRepository;
import com.example.java6.buoi1.repository.ProductRepository;
import com.example.java6.buoi1.request.ProductRequest;
import com.example.java6.buoi1.response.ProductResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductResponse> getAll() {
        return productRepository.getAll();
    }

    public ProductResponse detail(Integer id) {
        return productRepository.detail(id);
    }

    public List<ProductResponse> search(String code) {
        return productRepository.search(code);
    }

    public Page<ProductResponse> paging(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return productRepository.paging(pageable);
    }

    public void add(ProductRequest request) {
        Product p = new Product();
        BeanUtils.copyProperties(request, p);
        Category cate = categoryRepository.findById(request.getCategoryId()).orElse(null);
        p.setCategory(cate);
        productRepository.save(p);
    }

    public void update(ProductRequest request, Integer id) {
        Product p = productRepository.findById(id).get();
        BeanUtils.copyProperties(request, p);
        Category cate = categoryRepository.findById(request.getCategoryId()).orElse(null);
        p.setId(id);
        p.setCategory(cate);
        productRepository.save(p);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
