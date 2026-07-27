package com.example.asmgd_1.controller;

import com.example.asmgd_1.entity.SanPhamChiTiet;
import com.example.asmgd_1.request.SanPhamChiTietRequest;
import com.example.asmgd_1.response.SanPhamChiTietResponse;
import com.example.asmgd_1.service.SanPhamChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asm/san-pham-chi-tiet")
public class SanPhamChiTietController {

    @Autowired
    private SanPhamChiTietService service;

    @GetMapping
    public List<SanPhamChiTietResponse> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody SanPhamChiTietRequest request){
        service.addSanPhamChiTiet(request);
        return "Thêm thành công!";
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody SanPhamChiTietRequest request,@PathVariable Integer id){
        service.updateSanPhamChiTiet(request, id);
        return "Sửa thành công!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.deleteSanPhamChiTiet(id);
        return "Xóa thành công!";
    }
}
