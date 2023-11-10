package com.demo.service;

import com.demo.entity.HangKhachHang;

import java.util.List;

public interface HangKhachHangService {

    List<HangKhachHang> getAll();

    HangKhachHang add(HangKhachHang hangKhachHang);

    HangKhachHang update(HangKhachHang hangKhachHang, int maHang);

    boolean delete(int maHang);
}
