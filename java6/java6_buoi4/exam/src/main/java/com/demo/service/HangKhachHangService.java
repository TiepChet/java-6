package com.demo.service;

import com.demo.entity.HangKhachHang;

import java.util.List;

public interface HangKhachHangService {

    List<HangKhachHang> getAll();

    HangKhachHang getOne(int maHang);

    HangKhachHang add(HangKhachHang  hangKhachHang);

    HangKhachHang updateTodo(int maHang, HangKhachHang hangKhachHang);

    boolean delete(int maHang);

}
