package com.example.template.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KhachHangRequest {

    @NotBlank(message = "Nhập đủ thông tin")
    private String tenKhachHang;

    @NotBlank(message = "Nhập đủ thông tin")
    private String soDienThoai;

    @NotNull(message = "Nhập đủ thông tin")
    private boolean gioiTinh;

    @NotNull(message = "Nhập đủ thông tin")
    private int maHang;

    @NotEmpty(message = "Nhập đủ thông tin")
    private String tenHang;

    @NotBlank(message = "Nhập đủ thông tin")
    private String moTa;
}


