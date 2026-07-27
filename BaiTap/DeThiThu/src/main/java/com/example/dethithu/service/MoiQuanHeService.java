package com.example.dethithu.service;

import com.example.dethithu.repository.MoiQuanHeRepository;
import com.example.dethithu.response.MoiQuanHeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoiQuanHeService {

    @Autowired
    private MoiQuanHeRepository moiQuanHeRepository;

    public List<MoiQuanHeResponse> getAll(){
        return moiQuanHeRepository.getAll();
    }
}
