package com.demo.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChiTietSanPhamRequest {


    private UUID idSP;

    private UUID idNSX;

    private int namBH;

    private String moTa;

    private int soLuongTon;

    private float giaNhap;

    private float giaBan;
}
