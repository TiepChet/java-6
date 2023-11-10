package com.example.demo.controller;


import com.example.demo.entity.NhanVien;
import com.example.demo.service.NhanVienService;
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

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<NhanVien> getAll = nhanVienService.getAll();
        return ResponseEntity.ok(getAll);
    }

    @GetMapping("/locnv")
    public ResponseEntity<?> locNV(){
        List<NhanVien> locNV = nhanVienService.locNhanVien();
        return ResponseEntity.ok(locNV);
    }


    @GetMapping("/tongnv")
    public ResponseEntity<?> tongNV(){
        double tongNV = nhanVienService.tongLuong();
        return ResponseEntity.ok(tongNV);
    }

    @GetMapping("/luongcao")
    public ResponseEntity<?> luongCao(){
        Optional<NhanVien> luongCao = nhanVienService.luongCao();
        return ResponseEntity.ok(luongCao);
    }

    @GetMapping("/tbc")
    public ResponseEntity<?> tbc(){
        double tbc = nhanVienService.tbc();
        return ResponseEntity.ok(tbc);
    }

    @GetMapping("/tbp")
    public ResponseEntity<?> tbp(){
        double tbp = nhanVienService.tongBP();
        return ResponseEntity.ok(tbp);
    }

    @GetMapping("/tuoi")
    public ResponseEntity<?> tuoi(){
        List<NhanVien> tuoi = nhanVienService.tuoi();
        return ResponseEntity.ok(tuoi);
    }
}
