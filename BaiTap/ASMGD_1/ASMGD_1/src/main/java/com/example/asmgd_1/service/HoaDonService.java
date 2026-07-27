package com.example.asmgd_1.service;

import com.example.asmgd_1.entity.HoaDon;
import com.example.asmgd_1.entity.HoaDonChiTiet;
import com.example.asmgd_1.entity.KhachHang;
import com.example.asmgd_1.entity.NhanVien;
import com.example.asmgd_1.repository.HoaDonChiTietRepository;
import com.example.asmgd_1.repository.HoaDonReposioty;
import com.example.asmgd_1.repository.KhachHangRepository;
import com.example.asmgd_1.repository.NhanVienRepository;
import com.example.asmgd_1.request.HoaDonRequest;
import com.example.asmgd_1.response.HoaDonResponse;
import com.example.asmgd_1.response.NhanVienResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HoaDonService {

    @Autowired
    private HoaDonReposioty hoaDonReposioty;

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    public List<HoaDonResponse> getAll(){
        List<HoaDonResponse> listResponse = new ArrayList<>();
        List<HoaDon> listHoaDon = hoaDonReposioty.findAll();
        for (HoaDon hoaDon : listHoaDon){
            listResponse.add(convertToResponse(hoaDon));
        }
        return listResponse;
    }

    private HoaDonResponse convertToResponse(HoaDon hoaDon){
        HoaDonResponse response = new HoaDonResponse();
        response.setId(hoaDon.getId());
        response.setMaHoaDon(hoaDon.getMaHoaDon());
        response.setTenHoaDon(hoaDon.getTenHoaDon());
        response.setTenKhachHang(hoaDon.getKhachHang().getTenKhachHang());
        response.setTenNhanVien(hoaDon.getNhanVien().getTenNhanVien());
        response.setTenHoaDonChiTiet(hoaDon.getHoaDonChiTiet().getTenHoaDonChiTiet());
        response.setNgayTao(hoaDon.getNgayTao());
        response.setTrangThai(hoaDon.getTrangThai());
        return response;
    }

    public List<HoaDonResponse> searchHoaHon(String tenHoaDon){
        String searchKey = (tenHoaDon == null) ? "" : tenHoaDon.trim();
        return hoaDonReposioty.searchHoaDon(searchKey);
    }

    public void addHoaDon(HoaDonRequest request){
        HoaDon hoaDon = new HoaDon();
        BeanUtils.copyProperties(request, hoaDon);
        KhachHang khachHang = khachHangRepository.findById(request.getKhachHangId()).orElse(null);
        NhanVien nhanVien = nhanVienRepository.findById(request.getNhanVienId()).orElse(null);
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(request.getHoaDonChiTietId()).orElse(null);
        hoaDon.setKhachHang(khachHang);
        hoaDon.setNhanVien(nhanVien);
        hoaDon.setHoaDonChiTiet(hoaDonChiTiet);
        hoaDonReposioty.save(hoaDon);
    }

    public void updateHoaDon(HoaDonRequest request, Integer id){
        HoaDon hoaDon = hoaDonReposioty.findById(id).get();
        BeanUtils.copyProperties(request, hoaDon);
        KhachHang khachHang = khachHangRepository.findById(request.getKhachHangId()).orElse(null);
        NhanVien nhanVien = nhanVienRepository.findById(request.getNhanVienId()).orElse(null);
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(request.getHoaDonChiTietId()).orElse(null);
        hoaDon.setId(id);
        hoaDon.setKhachHang(khachHang);
        hoaDon.setNhanVien(nhanVien);
        hoaDon.setHoaDonChiTiet(hoaDonChiTiet);
        hoaDonReposioty.save(hoaDon);
    }

    public void deleteHoaDon(Integer id){
        hoaDonReposioty.deleteById(id);
    }
}
