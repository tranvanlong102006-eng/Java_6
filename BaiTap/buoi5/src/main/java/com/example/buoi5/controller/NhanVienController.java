package com.example.buoi5.controller;

import com.example.buoi5.request.NhanVienRequest;
import com.example.buoi5.response.NhanVienResponse;
import com.example.buoi5.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/nhan-vien")
@CrossOrigin(origins = "*")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public List<NhanVienResponse> getAll(){
        return nhanVienService.getAll();
    }

    @GetMapping("detail/{id}")
    public NhanVienResponse detail(@PathVariable Integer id){
        return nhanVienService.detailNhanVien(id);
    }

    @GetMapping("search")
    public List<NhanVienResponse> search(@RequestParam("ten") String ten){
        return nhanVienService.searchNhanVien(ten);
    }

    @GetMapping("paging")
    public List<NhanVienResponse> paging(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        return nhanVienService.pagingNhanVien(pageNo, pageSize).getContent();
    }

    @PostMapping("add")
    public void add(@Valid @RequestBody NhanVienRequest request){
        nhanVienService.addNhanVien(request);
    }

    @PutMapping("update/{id}")
    public void update(@Valid @RequestBody NhanVienRequest request, @PathVariable Integer id){
        nhanVienService.updateNhanVien(request, id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){
        nhanVienService.deleteNhanVien(id);
    }
}
