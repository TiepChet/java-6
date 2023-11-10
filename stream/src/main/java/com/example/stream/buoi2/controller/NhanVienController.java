package com.example.stream.buoi2.controller;

import com.example.stream.buoi2.entity.NhanVien;
import com.example.stream.buoi2.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<NhanVien> getAll = nhanVienService.getAll();
        return ResponseEntity.ok(getAll);
    }

    @GetMapping("/locnhanvien")
    public ResponseEntity<?> locNV(){
        List<NhanVien> locNV = nhanVienService.locNhanVien();
        return ResponseEntity.ok(locNV);
    }

    @GetMapping("/tongluong")
    public ResponseEntity<?> tongLuong(){
        double tongLuong = nhanVienService.tongLuong();
        return ResponseEntity.ok(tongLuong);
    }


    @GetMapping("/luongcao")
    public ResponseEntity<?> luongCao(){
        Optional<NhanVien> luongCao = nhanVienService.luongCao();
        return ResponseEntity.ok(luongCao);
    }

    @GetMapping("/sapxep")
    public ResponseEntity<?> sapxep(){
        List<NhanVien> sapXep = nhanVienService.sapXep();
        return ResponseEntity.ok(sapXep);
    }

    @GetMapping("/tuoi4x")
    public ResponseEntity<?> tuoi4x(){
        List<NhanVien> tuoi4x = nhanVienService.tuoi4x();
        return ResponseEntity.ok(tuoi4x);
    }

    @GetMapping("/tongbp")
    public ResponseEntity<?> tongBP(){
       double tongBP = nhanVienService.tongBP();
        return ResponseEntity.ok(tongBP);
    }

}
