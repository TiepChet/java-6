package com.demo.controller;


import com.demo.dao.ChiTietSanPhamCustom;
import com.demo.model.ChiTietSanPham;
import com.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/chitietsp")
public class ChiTietSanPhamController {

    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("/index")
    public ResponseEntity<?> hienThi() {
        List<ChiTietSanPhamCustom> getAll = chiTietSanPhamService.getAll();
        return ResponseEntity.ok(getAll);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") UUID id) {
        ChiTietSanPham detail = chiTietSanPhamService.getOne(id);
        return ResponseEntity.ok(detail);
    }
}
