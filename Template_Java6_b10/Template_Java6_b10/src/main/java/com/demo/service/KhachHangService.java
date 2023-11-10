package com.demo.service;

import com.demo.entity.KhachHang;
import com.demo.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {

    @Autowired
    public KhachHangRepo khachHangRepo;

    public Page<KhachHang> findAll(Pageable pageable) {
        return khachHangRepo.findAll(pageable);
    }

    public List<KhachHang> getAll() {
        return khachHangRepo.findAll();
    }

    public KhachHang add(KhachHang khachHang) {
        return khachHangRepo.save(khachHang);
    }

    public KhachHang update(long maKhachHang, KhachHang khachHang) {
        KhachHang updateKH = khachHangRepo.findById(maKhachHang).get();
        updateKH.setHangKhachHang(khachHang.getHangKhachHang());
        updateKH.setTenKhachHang(khachHang.getTenKhachHang());
        updateKH.setSoDienThoai(khachHang.getSoDienThoai());
        updateKH.setGioiTinh(khachHang.isGioiTinh());
        return khachHangRepo.save(updateKH);
    }

    public boolean delete(long maKhachHang) {
        khachHangRepo.deleteById(maKhachHang);
        return true;
    }



}
