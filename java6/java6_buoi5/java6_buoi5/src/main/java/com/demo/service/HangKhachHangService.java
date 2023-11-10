package com.demo.service;

import com.demo.entity.HangKhachHang;

import java.util.List;

public interface HangKhachHangService {

    List<HangKhachHang> getAll();

    void delele(int maHang);

    void save(HangKhachHang hangKhachHang);

    HangKhachHang getOne(int maHang);
}
