package com.demo.controller;

import com.demo.entity.HangKhachHang;
import com.demo.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HangKhachHangController {

    @Autowired
    HangKhachHangService hangKhachHangService;

    @GetMapping("/hien-thi")
    public List<HangKhachHang> hienThi() {
        return hangKhachHangService.getAll();
    }

    @PostMapping("/add")
    public HangKhachHang add(@RequestBody HangKhachHang hangKhachHang) {
        return hangKhachHangService.add(hangKhachHang);
    }


    @PutMapping("/update/{maHang}")
    public HangKhachHang update(@RequestBody HangKhachHang hangKhachHang, @PathVariable("maHang") int maHang) {
        return hangKhachHangService.update(hangKhachHang, maHang);
    }


    @DeleteMapping("/delete/{maHang}")
    public boolean delete(@PathVariable("maHang") int maHang) {
        return hangKhachHangService.delete(maHang);
    }
}
