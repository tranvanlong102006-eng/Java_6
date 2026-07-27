package com.example.asmgd_1.controller;

import com.example.asmgd_1.request.HoaDonChiTietRequest;
import com.example.asmgd_1.response.HoaDonChiTietResponse;
import com.example.asmgd_1.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asm/hoa-don-chi-tiet")
public class HoaDonChiTietController {

    @Autowired
    private HoaDonChiTietService service;

    @GetMapping
    public List<HoaDonChiTietResponse> getAll(){
        return service.getAll();
    }


    @PostMapping("/add")
    public String add(@RequestBody HoaDonChiTietRequest request){
        service.addHoaDonChiTiet(request);
        return "Thêm thành công!";
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody HoaDonChiTietRequest request, @PathVariable Integer id){
        service.updateHoaDonChiTiet(request, id);
        return "Sửa thành công!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        service.deleteHoaDonChiTiet(id);
        return "Xóa thành công!";
    }
}
