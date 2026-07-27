package com.example.asmgd_1.service;

import com.example.asmgd_1.entity.KhachHang;
import com.example.asmgd_1.repository.KhachHangRepository;
import com.example.asmgd_1.request.KhachHangRequest;
import com.example.asmgd_1.response.KhachHangResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    public List<KhachHangResponse> getAll() {
        List<KhachHangResponse> listResponse = new ArrayList<>();
        List<KhachHang> listKhachHang = khachHangRepository.findAll();
        for (KhachHang khachHang : listKhachHang) {
            listResponse.add(convertToResponse(khachHang));
        }
        return listResponse;
    }

    private KhachHangResponse convertToResponse(KhachHang khachHang) {
        KhachHangResponse response = new KhachHangResponse();
        response.setId(khachHang.getId());
        response.setMaKhachHang(khachHang.getMaKhachHang());
        response.setTenKhachHang(khachHang.getTenKhachHang());
        response.setGioiTinh(khachHang.getGioiTinh());
        response.setSoDienThoai(khachHang.getSoDienThoai());
        response.setNgaySinh(khachHang.getNgaySinh());
        response.setDiaChi(khachHang.getDiaChi());
        response.setDanhGia(khachHang.getDanhGia());
        response.setMatKhau(khachHang.getMatKhau());
        return response;
    }

    public List<KhachHangResponse> searchKhachHang(String tenKhachHang) {
        String searchKey = (tenKhachHang == null) ? "" : tenKhachHang.trim();
        return khachHangRepository.searchKhachHang(searchKey);
    }

    public void addKhachHang(KhachHangRequest request){
        KhachHang khachHang = new KhachHang();
        BeanUtils.copyProperties(request, khachHang);
        khachHangRepository.save(khachHang);
    }

    public void updateKhachHang(KhachHangRequest request, Integer id){
        KhachHang khachHang = khachHangRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(request, khachHang);
        khachHang.setId(id);
        khachHangRepository.save(khachHang);
    }
}
