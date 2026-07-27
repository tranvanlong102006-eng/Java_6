package com.example.asmgd_1.controller;


import com.example.asmgd_1.request.KhachHangRequest;
import com.example.asmgd_1.response.KhachHangResponse;
import com.example.asmgd_1.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.List;

@RestController
@RequestMapping("/asm/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService service;

    @GetMapping
    public List<KhachHangResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<KhachHangResponse> search(@RequestParam(value = "tenKhachHang", defaultValue = "") String ten) {
        return service.searchKhachHang(ten);
    }

    @PostMapping("/add")
    public String add(@RequestBody KhachHangRequest request){
        service.addKhachHang(request);
        return "Thêm thành công!";
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody KhachHangRequest request, @PathVariable Integer id){
        service.updateKhachHang(request, id);
        return "Sửa thành công!";
    }
}
