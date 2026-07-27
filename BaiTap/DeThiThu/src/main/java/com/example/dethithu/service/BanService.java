package com.example.dethithu.service;

import com.example.dethithu.entity.Ban;
import com.example.dethithu.entity.MoiQuanHe;
import com.example.dethithu.repository.BanRepository;
import com.example.dethithu.repository.MoiQuanHeRepository;
import com.example.dethithu.request.BanRequest;
import com.example.dethithu.response.BanResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanService {

    @Autowired
    private BanRepository banRepository;

    @Autowired
    private MoiQuanHeRepository moiQuanHeRepository;

    public List<BanResponse> getAll(){
        return banRepository.getAll();
    }

    public BanResponse detail(Integer id){
        return banRepository.detail(id);
    }

    public Page<BanResponse> paging(Integer pageNo, Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return banRepository.paging(pageable);
    }

    public void update(BanRequest request, Integer id){
        Ban b = banRepository.findById(id).get();
        BeanUtils.copyProperties(request, b);
        MoiQuanHe mqh = moiQuanHeRepository.findById(request.getMoiQuanHeId()).orElse(null);
        b.setId(id);
        b.setMoiQuanHe(mqh);
        banRepository.save(b);
    }

    public void delete(Integer id){
        banRepository.deleteById(id);
    }
}
