package com.example.dethithu.controller;

import com.example.dethithu.request.BanRequest;
import com.example.dethithu.response.BanResponse;
import com.example.dethithu.service.BanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ban")
@CrossOrigin(origins = "*")
public class BanController {

    @Autowired
    private BanService banService;

    @GetMapping
    public List<BanResponse> getAll(){
        return banService.getAll();
    }

    @GetMapping("detail/{id}")
    public BanResponse detail(@PathVariable Integer id){
        return banService.detail(id);
    }

    @GetMapping("paging")
    public List<BanResponse> paging(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        return banService.paging(pageNo, pageSize).getContent();
    }

    @PutMapping ("update/{id}")
    public void update(@Valid @RequestBody BanRequest request, @PathVariable Integer id){
        banService.update(request, id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){
        banService.delete(id);
    }
}
