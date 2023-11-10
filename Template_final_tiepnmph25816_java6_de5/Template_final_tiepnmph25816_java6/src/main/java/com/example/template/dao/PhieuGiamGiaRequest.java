package com.example.template.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhieuGiamGiaRequest {

    @NotBlank(message = "Không để trống")
    private String maPhieu;

    @NotBlank(message = "Không để trống")
    private String tenPhieu;

    @NotBlank(message = "Không để trống")
    private String ngayBatDau;

    @NotBlank(message = "Không để trống")
    private String giaTriGiam;

    private long maKhachHang;

    private String tenKhachHang;
}
