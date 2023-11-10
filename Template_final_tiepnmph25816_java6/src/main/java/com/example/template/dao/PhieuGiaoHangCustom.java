package com.example.template.dao;


import java.math.BigDecimal;
import java.util.UUID;


public interface PhieuGiaoHangCustom {

     UUID getMaPhieuGiao();

     String getNguoiNhan();

     String getSdtNhan();

     BigDecimal getPhiGiaoHang();

     String getNguoiLap();

     String getGhiChu();
}
