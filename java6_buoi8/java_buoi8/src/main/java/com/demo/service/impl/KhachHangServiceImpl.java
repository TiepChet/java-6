package com.demo.service.impl;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import com.demo.repository.KhachHangRepo;
import com.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepo  khachHangRepo;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepo.findAll();
    }

    @Override
    public KhachHang add(KhachHang khachHang) {
        return khachHangRepo.save(khachHang);
    }


    @Override
    public KhachHang getOne(long maKhachHang) {
        return khachHangRepo.findById(maKhachHang).get();
    }

    @Override
    public KhachHang update(long maKhachHang, KhachHang khachHang) {
        KhachHang update = khachHangRepo.findById(maKhachHang).get();
        update.setHangKhachHang(khachHang.getHangKhachHang());
        update.setTenKhachHang(khachHang.getTenKhachHang());
        return khachHangRepo.save(update);
    }

    @Override
    public boolean delete(long maKhachHang) {
        khachHangRepo.deleteById(maKhachHang);
        return true;
    }

    @Override
    public List<KhachHang> search(String tenKhachHang) {
        return khachHangRepo.search("%"+tenKhachHang+"%");
    }

    @Override
    public List<KhachHang> sapXep() {
        return khachHangRepo.sapXep();
    }
}
