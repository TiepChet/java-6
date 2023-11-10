package com.example.restapi.service;

import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.model.HangKhachHang;

import java.util.List;

public interface HangKhachHangService {

    List<HangKhachHang> getAll();

    HangKhachHang getOne(int maHang) throws ResourceNotFoundException;

    HangKhachHang add(HangKhachHang hangKhachHang);

    HangKhachHang update(int maHang, HangKhachHang hangKhachHang) throws ResourceNotFoundException;

    void delete(int maHang);

    List<HangKhachHang> search(String tenHang);


}
