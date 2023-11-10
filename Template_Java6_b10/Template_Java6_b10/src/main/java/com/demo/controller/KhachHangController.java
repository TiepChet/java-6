package com.demo.controller;

import com.demo.entity.KhachHang;
import com.demo.service.HangKhachHangService;
import com.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {

    @Autowired
    private HangKhachHangService hangKhachHangService;

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("")
    public ResponseEntity<Page<KhachHang>> getAll(@RequestParam(defaultValue = "0") int page) {
        hangKhachHangService.getAll();
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> getAll = khachHangService.findAll(pageable);
        return ResponseEntity.ok().body(getAll);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody KhachHang khachHang){
        hangKhachHangService.getAll();
        KhachHang add = khachHangService.add(khachHang);
        return ResponseEntity.ok().body(add);
    }

    @PutMapping("/update/{maKhachHang}")
    public ResponseEntity<?> update(@Valid @RequestBody KhachHang khachHang, @PathVariable("maKhachHang") long maKhachHang){
        hangKhachHangService.getAll();
        KhachHang add = khachHangService.update(maKhachHang,khachHang);
        return ResponseEntity.ok().body(add);
    }

    @DeleteMapping("/delete/{maKhachHang}")
    public ResponseEntity<?> delete(@PathVariable("maKhachHang") long maKhachHang){
        hangKhachHangService.getAll();
        boolean delete= khachHangService.delete(maKhachHang);
        return ResponseEntity.ok().body(delete);
    }

}
