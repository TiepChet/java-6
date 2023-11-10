package com.demo.dao;

import com.demo.model.HangKhachHang;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class KhachHangRequest {



    @NotBlank(message = "Không để trống")
    private String tenKhachHang;

    @NotBlank(message = "Không để trống")
    private String soDienThoai;

    @NotNull(message = "Không để trống")
    private boolean gioiTinh;

    private Integer maHang;

    private String tenHang;

}
