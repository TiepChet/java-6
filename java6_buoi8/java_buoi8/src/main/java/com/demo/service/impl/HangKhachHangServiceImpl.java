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
    HangKhachHangRepo  hangKhachHangRepo;

    @Override
    public List<HangKhachHang> getAll() {
        return hangKhachHangRepo.findAll();
    }

    @Override
    public HangKhachHang getOne(int maHang) {
        return hangKhachHangRepo.findById(maHang).get();
    }
}
