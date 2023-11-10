package com.example.template.dao;



import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class PhieuGiaoHangRequest {


    private UUID maPhieuGiao;

    private String nguoiNhan;

    private String sdtNhan;

    private BigDecimal phiGiaoHang;

    private String nguoiLap;

    private String ghiChu;
}
