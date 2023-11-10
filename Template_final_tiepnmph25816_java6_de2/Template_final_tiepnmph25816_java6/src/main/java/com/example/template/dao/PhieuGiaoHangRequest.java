package com.example.template.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhieuGiaoHangRequest {


    @NotBlank(message = "Không để trống")
    private String nguoiNhan;

    @NotBlank(message = "Không để trống")
    private String sdtNhan;

    @NotNull(message = "Không để trống")
    private float phiGiaoHang;

    private long maHoaDon;

    @NotBlank(message = "Không để trống")
    private String nguoiLap;

    @NotBlank(message = "Không để trống")
    private String ghiChu;
}
