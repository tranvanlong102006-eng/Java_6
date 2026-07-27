package com.example.asmgd_1.service;

import com.example.asmgd_1.entity.ChucVu;
import com.example.asmgd_1.entity.NhanVien;
import com.example.asmgd_1.repository.ChucVuRepository;
import com.example.asmgd_1.repository.NhanVienRepository;
import com.example.asmgd_1.request.NhanVienRequest;
import com.example.asmgd_1.response.KhachHangResponse;
import com.example.asmgd_1.response.NhanVienResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;

    public List<NhanVienResponse> getAll(){
        List<NhanVienResponse> listResponse = new ArrayList<>();
        List<NhanVien> listNhanVien = nhanVienRepository.findAll();
        for (NhanVien nhanVien : listNhanVien){
            listResponse.add(convertToResponse(nhanVien));
        }
        return listResponse;
    }

    private NhanVienResponse convertToResponse(NhanVien nhanVien){
        NhanVienResponse response = new NhanVienResponse();
        response.setId(nhanVien.getId());
        response.setMaNhanVien(nhanVien.getMaNhanVien());
        response.setTenNhanVien(nhanVien.getTenNhanVien());
        response.setTenChucVu(nhanVien.getChucVu().getTenChucVu());
        response.setGioiTinh(nhanVien.getGioiTinh());
        response.setSoDienThoai(nhanVien.getSoDienThoai());
        response.setEmail(nhanVien.getEmail());
        response.setNgaySinh(nhanVien.getNgaySinh());
        response.setDiaChi(nhanVien.getDiaChi());
        response.setMatKhau(nhanVien.getMatKhau());
        return response;
    }

    public List<NhanVienResponse> searchNhanVien(String tenNhanVien){
        String searchKey = (tenNhanVien == null) ? "" : tenNhanVien.trim();
        return nhanVienRepository.searchNhanVien(searchKey);
    }

    public void addNhanVien(NhanVienRequest request){
        NhanVien nhanVien = new NhanVien();
        BeanUtils.copyProperties(request, nhanVien);
        ChucVu chucVu = chucVuRepository.findById(request.getChucVuId()).orElse(null);
        nhanVien.setChucVu(chucVu);
        nhanVienRepository.save(nhanVien);
    }

    public void updateNhanVien(NhanVienRequest request, Integer id){
        NhanVien nhanVien = nhanVienRepository.findById(id).get();
        BeanUtils.copyProperties(request, nhanVien);
        ChucVu chucVu = chucVuRepository.findById(request.getChucVuId()).orElse(null);
        nhanVien.setId(id);
        nhanVien.setChucVu(chucVu);
        nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(Integer id){
        nhanVienRepository.deleteById(id);
    }



}
