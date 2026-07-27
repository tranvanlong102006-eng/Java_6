package com.example.java6.buoi1.controller;

import com.example.java6.buoi1.request.ProductRequest;
import com.example.java6.buoi1.response.ProductResponse;
import com.example.java6.buoi1.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("detail")
    public ProductResponse detail(@RequestParam("id") Integer id) {
        return productService.detail(id);
    }

    @GetMapping("search")
    public List<ProductResponse> search(@RequestParam("code") String code) {
        return productService.search(code);
    }

    @GetMapping("paging")
    public List<ProductResponse> paging(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        return productService.paging(pageNo, pageSize).getContent();
    }

    @PostMapping("add")
    public String add(@RequestBody ProductRequest request) {
        productService.add(request);
        return "Thêm thành công!";
    }

    @PutMapping("update")
    public String update(@RequestBody ProductRequest request, @RequestParam("id") Integer id) {
        productService.update(request, id);
        return "Sửa thành công!";
    }

    @DeleteMapping("delete")
    public String delete(@RequestParam("id") Integer id) {
        productService.delete(id);
        return "Xóa thành công!";
    }
}
