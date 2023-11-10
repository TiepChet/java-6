package com.demo.service;

import com.demo.entity.HangKhachHang;

import java.util.List;

public interface HangKhachHangService {

    List<HangKhachHang> getAll();

    HangKhachHang getOne(int maHang);

    void save(HangKhachHang hangKhachHang);

    void delete(int maHang);
}
