package com.demo.service;

import com.demo.entity.HangKhachHang;
import com.demo.repository.HangKhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangKhachHangService {

    @Autowired
    HangKhachHangRepo hangKhachHangRepo;

    public List<HangKhachHang> getAll(){
        return hangKhachHangRepo.findAll();
    }
}
