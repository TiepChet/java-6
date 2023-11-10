package com.example.template.dao;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PhieuGiaoHangRequest {


    private String nguoiNhan;

    private String sdtNhan;

    private Long maHoaDon;

    private String nguoiLap;

    private UUID maDiaChi;

    private String tenDiaChi;

    private String moTaChiTiet;
}
