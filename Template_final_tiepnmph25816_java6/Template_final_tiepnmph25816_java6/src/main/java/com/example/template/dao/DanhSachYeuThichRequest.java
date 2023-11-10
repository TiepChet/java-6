package com.example.template.dao;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DanhSachYeuThichRequest {

    private String ngayTao;

    private String ngayCapNhap;

    private long maKhachHang;

    private String tenKhachHang;
}
