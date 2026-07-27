package com.example.asmgd_1.service;

import com.example.asmgd_1.entity.NhaSanXuat;
import com.example.asmgd_1.repository.NhaSanXuatRepository;
import com.example.asmgd_1.repository.NhanVienRepository;
import com.example.asmgd_1.request.NhaSanXuatRequest;
import com.example.asmgd_1.response.NhaSanXuatResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhaSanXuatService {

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    public List<NhaSanXuatResponse> getAll(){
        List<NhaSanXuatResponse> listResponse = new ArrayList<>();
        List<NhaSanXuat> listNhaSanXuat = nhaSanXuatRepository.findAll();
        for (NhaSanXuat nhaSanXuat : listNhaSanXuat){
            listResponse.add(convertToResponse(nhaSanXuat));
        }
        return listResponse;
    }

    private NhaSanXuatResponse convertToResponse(NhaSanXuat nhaSanXuat){
        NhaSanXuatResponse response = new NhaSanXuatResponse();
        response.setId(nhaSanXuat.getId());
        response.setMaNhaSanXuat(nhaSanXuat.getMaNhaSanXuat());
        response.setTenNhaSanXuat(nhaSanXuat.getTenNhaSanXuat());
        return response;
    }

    public void addNhaSanXuat(NhaSanXuatRequest request){
        NhaSanXuat nhaSanXuat = new NhaSanXuat();
        BeanUtils.copyProperties(request, nhaSanXuat);
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    public void updateNhaSanXuat(NhaSanXuatRequest request, Integer id){
        NhaSanXuat nhaSanXuat = nhaSanXuatRepository.findById(id).get();
        BeanUtils.copyProperties(request, nhaSanXuat);
        nhaSanXuat.setId(id);
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    public void deleteNhaSanXuat(Integer id){
        nhaSanXuatRepository.deleteById(id);
    }
}
