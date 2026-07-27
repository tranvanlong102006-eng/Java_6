package com.example.asmgd_1.service;

import com.example.asmgd_1.entity.HoaDonChiTiet;
import com.example.asmgd_1.entity.PhieuGiamGia;
import com.example.asmgd_1.entity.SanPhamChiTiet;
import com.example.asmgd_1.repository.HoaDonChiTietRepository;
import com.example.asmgd_1.repository.PhieuGiamGiaRepository;
import com.example.asmgd_1.repository.SanPhamChiTietRepository;
import com.example.asmgd_1.request.HoaDonChiTietRequest;
import com.example.asmgd_1.response.HoaDonChiTietResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HoaDonChiTietService {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;

    @Autowired
    private PhieuGiamGiaRepository phieuGiamGiaRepository;

    public List<HoaDonChiTietResponse> getAll(){
        List<HoaDonChiTietResponse> listResponset = new ArrayList<>();
        List<HoaDonChiTiet> listHoaDonChiTiet = hoaDonChiTietRepository.findAll();
        for (HoaDonChiTiet hoaDonChiTiet : listHoaDonChiTiet){
            listResponset.add(convertToResponse(hoaDonChiTiet));
        }
        return listResponset;
    }

    private HoaDonChiTietResponse convertToResponse(HoaDonChiTiet hoaDonChiTiet){
        HoaDonChiTietResponse response = new HoaDonChiTietResponse();
        response.setId(hoaDonChiTiet.getId());
        response.setMaHoaDonChiTiet(hoaDonChiTiet.getMaHoaDonChiTiet());
        response.setTenHoaDonChiTiet(hoaDonChiTiet.getTenHoaDonChiTiet());
        response.setTenSanPhamChiTiet(hoaDonChiTiet.getSanPhamChiTiet().getTenSanPhamChiTiet());
        response.setTenPhieuGiamGia(hoaDonChiTiet.getPhieuGiamGia().getTenPhieuGiamGia());
        response.setSoLuong(hoaDonChiTiet.getSoLuong());
        response.setDonGia(hoaDonChiTiet.getDonGia());
        return response;
    }

    public void addHoaDonChiTiet(HoaDonChiTietRequest request){
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        BeanUtils.copyProperties(request, hoaDonChiTiet);
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietRepository.findById(request.getSanPhamChiTietId()).orElse(null);
        PhieuGiamGia phieuGiamGia = phieuGiamGiaRepository.findById(request.getPhieuGiamGiaId()).orElse(null);
        hoaDonChiTiet.setSanPhamChiTiet(sanPhamChiTiet);
        hoaDonChiTiet.setPhieuGiamGia(phieuGiamGia);
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    public void updateHoaDonChiTiet(HoaDonChiTietRequest request, Integer id){
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(id).get();
        BeanUtils.copyProperties(request, hoaDonChiTiet);
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietRepository.findById(request.getSanPhamChiTietId()).orElse(null);
        PhieuGiamGia phieuGiamGia = phieuGiamGiaRepository.findById(request.getPhieuGiamGiaId()).orElse(null);
        hoaDonChiTiet.setId(id);
        hoaDonChiTiet.setSanPhamChiTiet(sanPhamChiTiet);
        hoaDonChiTiet.setPhieuGiamGia(phieuGiamGia);
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    public void deleteHoaDonChiTiet(Integer id){
        hoaDonChiTietRepository.deleteById(id);
    }
}
