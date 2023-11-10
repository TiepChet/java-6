package com.example.template.controller;

import com.example.template.dao.KhachHangCustom;
import com.example.template.dao.KhachHangRequest;
import com.example.template.model.KhachHang;
import com.example.template.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<KhachHangCustom> getAll = khachHangService.getAll();
        return ResponseEntity.ok().body(getAll);
    }

    @GetMapping("/detail/{maKhachHang}")
    public ResponseEntity<?> detail(@PathVariable("maKhachHang") long maKhachHang) {
        KhachHang detail = khachHangService.getOne(maKhachHang);
        return ResponseEntity.ok().body(detail);
    }

    @DeleteMapping("/delete/{maKhachHang}")
    public ResponseEntity<?> delete(@PathVariable("maKhachHang") long maKhachHang) {
        boolean delete = khachHangService.delete(maKhachHang);
        return ResponseEntity.ok().body(delete);
    }


    @PutMapping("/update/{maKhachHang}")
    public ResponseEntity<?> update(@PathVariable("maKhachHang") long maKhachHang, @RequestBody KhachHangRequest request) {
        KhachHang update = khachHangService.update(maKhachHang, request);
        return ResponseEntity.ok().body(update);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody KhachHangRequest request) {
        KhachHang add = khachHangService.add(request);
        return ResponseEntity.ok().body(add);
    }
}
