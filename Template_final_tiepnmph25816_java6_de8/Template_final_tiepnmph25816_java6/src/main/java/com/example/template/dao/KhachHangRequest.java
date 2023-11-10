package com.example.template.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KhachHangRequest {

    private String tenKhachHang;

    private String soDienThoai;

    private boolean gioiTinh;

    private int maHang;

    private String tenHang;
}
