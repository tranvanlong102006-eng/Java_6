package com.example.asmgd_1.service;

import com.example.asmgd_1.entity.ChucVu;
import com.example.asmgd_1.repository.ChucVuRepository;
import com.example.asmgd_1.request.ChucVuRequest;
import com.example.asmgd_1.response.ChucVuResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChucVuService
{
    @Autowired
    private ChucVuRepository chucVuRepository;

    public List<ChucVuResponse> getAll(){
        List<ChucVuResponse> listResponse = new ArrayList<>();
        List<ChucVu> listChucVu = chucVuRepository.findAll();
        for (ChucVu chucVu : listChucVu){
            listResponse.add(convertToResponse(chucVu));
        }
        return listResponse;
    }

    private ChucVuResponse convertToResponse(ChucVu chucVu){
        ChucVuResponse chucVuResponse = new ChucVuResponse();
        chucVuResponse.setId(chucVu.getId());
        chucVuResponse.setMaChucVu(chucVu.getMaChucVu());
        chucVuResponse.setTenChucVu(chucVu.getTenChucVu());
        return chucVuResponse;
    }

    public void addChucVu(ChucVuRequest request){
        ChucVu chucVu = new ChucVu();
        BeanUtils.copyProperties(request, chucVu);
        chucVuRepository.save(chucVu);
    }

    public void updateChucVu(ChucVuRequest request, Integer id){
        ChucVu chucVu = chucVuRepository.findById(id).get();
        BeanUtils.copyProperties(request, chucVu);
        chucVu.setId(id);
        chucVuRepository.save(chucVu);
    }

    public void deleteChucVu(Integer id){
        chucVuRepository.deleteById(id);
    }
}
