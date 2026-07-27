package com.example.asmgd_1.service;

import com.example.asmgd_1.entity.SanPham;
import com.example.asmgd_1.repository.SanPhamRepository;
import com.example.asmgd_1.request.SanPhamChiTietRequest;
import com.example.asmgd_1.request.SanPhamRequest;
import com.example.asmgd_1.response.SanPhamResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPhamResponse> getAll(){
        List<SanPhamResponse> listResponse = new ArrayList<>();
        List<SanPham> listSanPham = sanPhamRepository.findAll();
        for (SanPham sanPham : listSanPham){
            listResponse.add(convertToResponse(sanPham));
        }
        return listResponse;
    }

    private SanPhamResponse convertToResponse(SanPham sanPham){
        SanPhamResponse response = new SanPhamResponse();
        response.setId(sanPham.getId());
        response.setMaSanPham(sanPham.getMaSanPham());
        response.setTenSanPham(sanPham.getTenSanPham());
        return response;
    }

    public void addSanPham(SanPhamRequest request){
        SanPham sanPham = new SanPham();
        BeanUtils.copyProperties(request, sanPham);
        sanPhamRepository.save(sanPham);
    }

    public void updateSanPham(SanPhamRequest request, Integer id){
        SanPham sanPham = sanPhamRepository.findById(id).get();
        BeanUtils.copyProperties(request, sanPham);
        sanPham.setId(id);
        sanPhamRepository.save(sanPham);
    }

    public void deleteSanPham(Integer id){
        sanPhamRepository.deleteById(id);
    }
}
