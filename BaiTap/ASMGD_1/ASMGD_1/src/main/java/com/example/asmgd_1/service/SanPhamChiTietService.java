package com.example.asmgd_1.service;

import com.example.asmgd_1.entity.*;
import com.example.asmgd_1.repository.*;
import com.example.asmgd_1.request.SanPhamChiTietRequest;
import com.example.asmgd_1.response.SanPhamChiTietResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamChiTietService {

    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    public List<SanPhamChiTietResponse> getAll(){
        List<SanPhamChiTietResponse> listResponse = new ArrayList<>();
        List<SanPhamChiTiet> listSanPhamChiTiet = sanPhamChiTietRepository.findAll();
        for (SanPhamChiTiet sanPhamChiTiet : listSanPhamChiTiet){
            listResponse.add(convertToResponse(sanPhamChiTiet));
        }
        return listResponse;
    }

    private SanPhamChiTietResponse convertToResponse(SanPhamChiTiet sanPhamChiTiet){
        SanPhamChiTietResponse response = new SanPhamChiTietResponse();
        response.setId(sanPhamChiTiet.getId());
        response.setMaSanPhamChiTiet(sanPhamChiTiet.getMaSanPhamChiTiet());
        response.setTenSanPhamChiTiet(sanPhamChiTiet.getTenSanPhamChiTiet());
        response.setTenSanPham(sanPhamChiTiet.getSanPham().getTenSanPham());
        response.setTenNhaSanXuat(sanPhamChiTiet.getNhaSanXuat().getTenNhaSanXuat());
        response.setTenMauSac(sanPhamChiTiet.getMauSac().getTenMauSac());
        response.setTenThuongHieu(sanPhamChiTiet.getThuongHieu().getTenThuongHieu());
        response.setMoTa(sanPhamChiTiet.getMoTa());
        response.setSoLuongTon(sanPhamChiTiet.getSoLuongTon());
        response.setGiaNhap(sanPhamChiTiet.getGiaNhap());
        response.setGiaBan(sanPhamChiTiet.getGiaBan());
        return response;
    }

    public void addSanPhamChiTiet(SanPhamChiTietRequest request){
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        BeanUtils.copyProperties(request, sanPhamChiTiet);
        SanPham sanPham = sanPhamRepository.findById(request.getSanPhamId()).orElse(null);
        NhaSanXuat nhaSanXuat = nhaSanXuatRepository.findById(request.getNhaSanXuatId()).orElse(null);
        MauSac mauSac = mauSacRepository.findById(request.getMauSacId()).orElse(null);
        ThuongHieu thuongHieu = thuongHieuRepository.findById(request.getThuongHieuId()).orElse(null);
        sanPhamChiTiet.setSanPham(sanPham);
        sanPhamChiTiet.setNhaSanXuat(nhaSanXuat);
        sanPhamChiTiet.setMauSac(mauSac);
        sanPhamChiTiet.setThuongHieu(thuongHieu);
        sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    public void updateSanPhamChiTiet(SanPhamChiTietRequest request, Integer id){
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietRepository.findById(id).get();
        BeanUtils.copyProperties(request, sanPhamChiTiet);
        SanPham sanPham = sanPhamRepository.findById(request.getSanPhamId()).orElse(null);
        NhaSanXuat nhaSanXuat = nhaSanXuatRepository.findById(request.getNhaSanXuatId()).orElse(null);
        MauSac mauSac = mauSacRepository.findById(request.getMauSacId()).orElse(null);
        ThuongHieu thuongHieu = thuongHieuRepository.findById(request.getThuongHieuId()).orElse(null);
        sanPhamChiTiet.setId(id);
        sanPhamChiTiet.setSanPham(sanPham);
        sanPhamChiTiet.setNhaSanXuat(nhaSanXuat);
        sanPhamChiTiet.setMauSac(mauSac);
        sanPhamChiTiet.setThuongHieu(thuongHieu);
        sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    public void deleteSanPhamChiTiet(Integer id){
        sanPhamChiTietRepository.deleteById(id);
    }
}
