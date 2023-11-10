package com.example.demo.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int maHang){
        super("HangKhachHang not found with id: "+maHang);
    }
}
