package com.example.java6.buoi1.service;

import com.example.java6.buoi1.repository.CategoryRepository;
import com.example.java6.buoi1.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryResponse> getAll() {
        return categoryRepository.getAll();
    }
}
