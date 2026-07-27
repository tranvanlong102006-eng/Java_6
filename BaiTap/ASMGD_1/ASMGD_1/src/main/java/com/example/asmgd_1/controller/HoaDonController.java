package com.example.asmgd_1.controller;

import com.example.asmgd_1.entity.HoaDon;
import com.example.asmgd_1.request.HoaDonRequest;
import com.example.asmgd_1.response.HoaDonResponse;
import com.example.asmgd_1.service.HoaDonService;
import org.hibernate.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asm/hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @GetMapping
    public List<HoaDonResponse> getAll(){
        return hoaDonService.getAll();
    }

    @GetMapping("/search")
    public List<HoaDonResponse> searchHoaDon(@RequestParam(value = "tenHoaDon", defaultValue = " ") String tenHoaDon){
        return hoaDonService.searchHoaHon(tenHoaDon);
    }

    @PostMapping("/add")
    public String add(@RequestBody HoaDonRequest request){
         hoaDonService.addHoaDon(request);
         return "Thêm thành công!";
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody HoaDonRequest request, @PathVariable Integer id){
        hoaDonService.updateHoaDon(request, id);
        return "Sửa thành công!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        hoaDonService.deleteHoaDon(id);
        return "Xóa thành công!";
    }
}
