package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.HangKhachHangService;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@CrossOrigin

public class KhachHangController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    HangKhachHangService hangKhachHangService;

    @GetMapping("/index")
    public ResponseEntity<List<KhachHang>> hienThi() {
        hangKhachHangService.getAll();
        List<KhachHang> khachHangs = khachHangService.getAll();
        return ResponseEntity.ok().body(khachHangs);
    }


    @PostMapping("/add")
    public ResponseEntity<KhachHang> add(@RequestBody KhachHang khachHang) {
        KhachHang khachHangs = khachHangService.add(khachHang);
        return ResponseEntity.ok().body(khachHangs);
    }

    @PutMapping("/update/{maKhachHang}")
    public ResponseEntity<KhachHang> update(@PathVariable("maKhachHang") long maKhachHang,
                                            @RequestBody KhachHang khachHang) throws ResourceAccessException {
        KhachHang khachHangs = khachHangService.update(maKhachHang, khachHang);
        return ResponseEntity.ok().body(khachHangs);
    }

    @DeleteMapping("/delete/{maKhachHang}")
    public ResponseEntity<?> delete(@PathVariable("maKhachHang") long maKhachHang) {
        khachHangService.delete(maKhachHang);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/detail/{maKhachHang}")
    public ResponseEntity<KhachHang> getOne(@PathVariable("maKhachHang") long maKhachHang) throws ResourceAccessException {
        hangKhachHangService.getAll();
        KhachHang khachHang = khachHangService.getOne(maKhachHang);
        return ResponseEntity.ok().body(khachHang);
    }

}
