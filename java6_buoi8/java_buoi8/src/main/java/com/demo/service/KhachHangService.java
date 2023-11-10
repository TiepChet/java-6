package com.demo.service;

import com.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang add(KhachHang khachHang);

    KhachHang getOne(long maKhachHang);

    KhachHang update(long maKhachHang, KhachHang khachHang);

    boolean delete(long maKhachHang);

    List<KhachHang> search(String tenKhachHang);

    List<KhachHang> sapXep();
}
