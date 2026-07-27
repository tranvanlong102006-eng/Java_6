package com.example.buoi5.controller;

import com.example.buoi5.response.ChucVuResponse;
import com.example.buoi5.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/chuc-vu")
@CrossOrigin(origins = "*")
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping
    public List<ChucVuResponse> getAll(){
        return chucVuService.getAll();
    }
}
