package com.example.template.service;

import com.example.template.dao.KhachHangCustom;
import com.example.template.dao.KhachHangRequest;
import com.example.template.model.HangKhachHang;
import com.example.template.model.KhachHang;
import com.example.template.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
KhachHangService {

    @Autowired
    private KhachHangRepo khachHangRepo;

    public List<KhachHangCustom> getAll() {
        return khachHangRepo.getAll();
    }

    public KhachHang getOne(long maKhachHang) {
        return khachHangRepo.findById(maKhachHang).get();
    }

    public boolean delete(long maKhachHang) {
        khachHangRepo.deleteById(maKhachHang);
        return true;
    }

    public KhachHang add(KhachHangRequest request) {
        KhachHang khachHang = new KhachHang();
        khachHang.setTenKhachHang(request.getTenKhachHang());
        khachHang.setGioiTinh(request.isGioiTinh());
        khachHang.setSoDienThoai(request.getSoDienThoai());
        khachHang.setHangKhachHang(HangKhachHang.builder().maHang(request.getMaHang()).tenHang(request.getTenHang()).build());
        return khachHangRepo.save(khachHang);
    }

    public KhachHang update(long maKhachHang,KhachHangRequest request) {
        KhachHang khachHang = khachHangRepo.findById(maKhachHang).get();
        khachHang.setTenKhachHang(request.getTenKhachHang());
        khachHang.setGioiTinh(request.isGioiTinh());
        khachHang.setSoDienThoai(request.getSoDienThoai());
        khachHang.setHangKhachHang(HangKhachHang.builder().maHang(request.getMaHang()).tenHang(request.getTenHang()).build());
        return khachHangRepo.save(khachHang);
    }
}
