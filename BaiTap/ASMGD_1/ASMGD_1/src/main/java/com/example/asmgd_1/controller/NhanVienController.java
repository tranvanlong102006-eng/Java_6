package com.example.asmgd_1.controller;

import com.example.asmgd_1.entity.NhanVien;
import com.example.asmgd_1.request.NhanVienRequest;
import com.example.asmgd_1.response.NhanVienResponse;
import com.example.asmgd_1.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asm/nhan-vien")
public class NhanVienController {

    @Autowired
    private NhanVienService service;

    @GetMapping
    public List<NhanVienResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/search")
    public List<NhanVienResponse> search(@RequestParam("tenNhanVien") String tenNhanVien){
        return service.searchNhanVien(tenNhanVien);
    }

    @PostMapping("/add")
    public String add(@RequestBody NhanVienRequest request){
        service.addNhanVien(request);
        return "Thêm thành công!";
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody NhanVienRequest request, @PathVariable Integer id){
        service.updateNhanVien(request, id);
        return "Sửa thành công!";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        service.deleteNhanVien(id);
        return "Xóa thành công!";
    }

}
