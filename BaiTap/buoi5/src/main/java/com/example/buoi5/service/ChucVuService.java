package com.example.buoi5.service;

import com.example.buoi5.repository.ChucVuRepository;
import com.example.buoi5.response.ChucVuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    public List<ChucVuResponse> getAll(){
        return chucVuRepository.getAll();
    }
}
