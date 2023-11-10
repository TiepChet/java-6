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
    public void delele(int maHang) {
        hangKhachHangRepo.deleteById(maHang);
    }

    @Override
    public void save(HangKhachHang hangKhachHang) {
        hangKhachHangRepo.save(hangKhachHang);
    }

    @Override
    public HangKhachHang getOne(int maHang) {
        return hangKhachHangRepo.findById(maHang).get();
    }
}
