package com.demo.service.impl;

import com.demo.entity.HangKhachHang;
import com.demo.repository.HangKhachHangRepo;
import com.demo.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangKhachHangServiceImpl implements HangKhachHangService {

    @Autowired
    HangKhachHangRepo hangKhachHangRepo;

    @Override
    public List<HangKhachHang> getAll() {
        return hangKhachHangRepo.findAll();
    }

    @Override
    public HangKhachHang add(HangKhachHang hangKhachHang) {
        return hangKhachHangRepo.save(hangKhachHang);
    }

    @Override
    public HangKhachHang update(HangKhachHang hangKhachHang, int maHang) {
        HangKhachHang update = hangKhachHangRepo.findById(maHang).get();
        update.setTenHang(hangKhachHang.getTenHang());
        update.setMoTa(hangKhachHang.getMoTa());
        update.setDiemToiThieu(Integer.valueOf(hangKhachHang.getDiemToiThieu()));
        update.setTrangThai(Integer.valueOf(hangKhachHang.getTrangThai()));
        return hangKhachHangRepo.save(update);

    }

    @Override
    public boolean delete(int maHang) {
        hangKhachHangRepo.deleteById(maHang);
        return true;
    }
}
