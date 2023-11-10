package com.example.template.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TheThanhVienRequest {

    private String maThe;

    private String mauThe;

    private String loaiThe;

    private long maKhachHang;

    private String tenKhachHang;

    private String diaChi;
}
