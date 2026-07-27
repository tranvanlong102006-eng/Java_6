package com.example.dethithu.controller;

import com.example.dethithu.response.MoiQuanHeResponse;
import com.example.dethithu.service.MoiQuanHeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/moi-quan-he")
@CrossOrigin(origins = "*")
public class MoiQuanHeController {

    @Autowired
    private MoiQuanHeService moiQuanHeService;

    @GetMapping
    public List<MoiQuanHeResponse> getAll(){
        return moiQuanHeService.getAll();
    }
}
