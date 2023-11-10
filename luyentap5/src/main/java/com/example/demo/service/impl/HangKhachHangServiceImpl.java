package com.example.demo.service.impl;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.repository.HangKhachHangRepo;
import com.example.demo.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class HangKhachHangServiceImpl implements HangKhachHangService {

    @Autowired
    HangKhachHangRepo hangKhachHangRepo;


    @Override
    public List<HangKhachHang> getAll() {
        return hangKhachHangRepo.findAll();
    }

    @Override
    public HangKhachHang getOne(int maHang) throws ResourceAccessException {
        Optional<HangKhachHang> findID = hangKhachHangRepo.findById(maHang);
        if(findID.isPresent()){
            return findID.get();
        }
        throw  new ResourceAccessException("HangKhachHang not found with id: "+maHang);
    }

    @Override
    public HangKhachHang add(HangKhachHang hangKhachHang) {
        return hangKhachHangRepo.save(hangKhachHang);
    }

    @Override
    public HangKhachHang update(int maHang, HangKhachHang hangKhachHang) throws ResourceAccessException {
        Optional<HangKhachHang> findID = hangKhachHangRepo.findById(maHang);
        if(findID.isPresent()){
            HangKhachHang updateKhachHang = findID.get();
            updateKhachHang.setTenHang(hangKhachHang.getTenHang());
            updateKhachHang.setMoTa(hangKhachHang.getMoTa());
            updateKhachHang.setDiemToiThieu(hangKhachHang.getDiemToiThieu());
            updateKhachHang.setTrangThai(hangKhachHang.getTrangThai());
            return hangKhachHangRepo.save(updateKhachHang);
        }
        throw  new ResourceAccessException("HangKhachHang not found with id: "+maHang);
    }

    @Override
    public void delete(int maHang) {
        hangKhachHangRepo.deleteById(maHang);
    }

    @Override
    public List<HangKhachHang> search(String tenHang) {
        return hangKhachHangRepo.search(tenHang);
    }
}
