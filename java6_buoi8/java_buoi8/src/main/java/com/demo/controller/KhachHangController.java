package com.demo.controller;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import com.demo.service.HangKhachHangService;
import com.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KhachHangController {

    @Autowired
    HangKhachHangService hangKhachHangService;

    @Autowired
    KhachHangService khachHangService;

    private HangKhachHang hangKhachHang;


    @GetMapping("/hien-thi")
    public List<KhachHang> hienThi() {
        hangKhachHangService.getAll();
        return khachHangService.getAll();
    }

    @PostMapping("/add")
    public KhachHang add(@RequestBody KhachHang khachHang) {
        hangKhachHangService.getAll();
        return khachHangService.add(khachHang);
    }


    @PutMapping({"/update/{maKhachHang}"})
    public KhachHang update(@PathVariable("maKhachHang") long maKhachHang,
                            @RequestBody KhachHang khachHang) {
        hangKhachHangService.getAll();
        return khachHangService.update(maKhachHang, khachHang);
    }

    @DeleteMapping("/delete/{maKhachHang}")
    public boolean delete(@PathVariable("maKhachHang") long maKhachHang) {
        hangKhachHangService.getAll();
        return khachHangService.delete(maKhachHang);
    }

    @GetMapping("/search")
    public List<KhachHang> search(@RequestParam("tenKhachHang") String tenKhachHang) {
        hangKhachHangService.getAll();
        return khachHangService.search(tenKhachHang);
    }

    @GetMapping("/sap-xep")
    public List<KhachHang> sapXep() {
        hangKhachHangService.getAll();
        return khachHangService.sapXep();
    }

}
