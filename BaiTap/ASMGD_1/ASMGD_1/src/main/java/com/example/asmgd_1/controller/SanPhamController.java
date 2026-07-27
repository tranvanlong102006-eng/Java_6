package com.example.asmgd_1.controller;

import com.example.asmgd_1.request.SanPhamRequest;
import com.example.asmgd_1.response.SanPhamResponse;
import com.example.asmgd_1.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asm/san-pham")
public class SanPhamController {

    @Autowired
    private SanPhamService service;

    @GetMapping
    public List<SanPhamResponse> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody SanPhamRequest request){
        service.addSanPham(request);
        return "Thêm thành công!";
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody SanPhamRequest request, @PathVariable Integer id){
        service.updateSanPham(request, id);
        return "Sửa thành công!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.deleteSanPham(id);
        return "Xóa thành công!";
    }
}
