package com.example.buoi5.service;

import com.example.buoi5.entity.ChucVu;
import com.example.buoi5.entity.NhanVien;
import com.example.buoi5.repository.ChucVuRepository;
import com.example.buoi5.repository.NhanVienRepository;
import com.example.buoi5.request.NhanVienRequest;
import com.example.buoi5.response.NhanVienResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;

    public List<NhanVienResponse> getAll(){
        return nhanVienRepository.getAll();
    }

    public NhanVienResponse detailNhanVien(Integer id){
        return nhanVienRepository.detail(id);
    }

    public Page<NhanVienResponse> pagingNhanVien(Integer pageSize, Integer pageNo){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return nhanVienRepository.paging(pageable);
    }

    public List<NhanVienResponse> searchNhanVien(String ten){
        return nhanVienRepository.search(ten);
    }

    public void addNhanVien(NhanVienRequest request){
        NhanVien nv = new NhanVien();
        BeanUtils.copyProperties(request, nv);
        ChucVu cv = chucVuRepository.findById(request.getChucVuId()).orElse(null);
        nv.setChucVu(cv);
        nhanVienRepository.save(nv);
    }

    public void updateNhanVien(NhanVienRequest request, Integer id){
        NhanVien nv = nhanVienRepository.findById(id).get();
        BeanUtils.copyProperties(request, nv);
        ChucVu cv = chucVuRepository.findById(request.getChucVuId()).orElse(null);
        nv.setId(id);
        nv.setChucVu(cv);
        nhanVienRepository.save(nv);
    }

    public void deleteNhanVien(Integer id){
        nhanVienRepository.deleteById(id);
    }
}
