package com.example.asmgd_1.controller;

import com.example.asmgd_1.request.ChucVuRequest;
import com.example.asmgd_1.response.ChucVuResponse;
import com.example.asmgd_1.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asm/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuService service;

    @GetMapping
    public List<ChucVuResponse> getAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody ChucVuRequest request){
        service.addChucVu(request);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody ChucVuRequest request, @PathVariable Integer id){
        service.updateChucVu(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteChucVu(id);
    }
}
