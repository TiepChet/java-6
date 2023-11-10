package com.example.demo.controller;

import com.example.demo.entity.NhanVien;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("/index")
    public ResponseEntity<List<NhanVien>> index(){
        List<NhanVien> listNhanVien = nhanVienService.getAll();
        return ResponseEntity.ok().body(listNhanVien);
    }

    @GetMapping("/loc")
    public ResponseEntity<List<NhanVien>> loc(){
        nhanVienService.getAll();
        List<NhanVien> loc = nhanVienService.loc();
        return ResponseEntity.ok().body(loc);
    }


    @GetMapping("/luong-cao")
    public ResponseEntity<?> luongCao(){
        nhanVienService.getAll();
        Optional<NhanVien> luongCao = nhanVienService.luongCao();
        return ResponseEntity.ok().body(luongCao);
    }


    @GetMapping("/sort")
    public ResponseEntity<List<NhanVien>> sort(){
        nhanVienService.getAll();
        List<NhanVien> sort = nhanVienService.sort();
        return ResponseEntity.ok().body(sort);
    }

    @GetMapping("/tuoi")
    public ResponseEntity<?> tuoi(){
        nhanVienService.getAll();
        List<NhanVien> tuoi = nhanVienService.tuoi();
        return ResponseEntity.ok().body(tuoi);
    }

    @GetMapping("/tong")
    public ResponseEntity<?> tong(){
        double tong = nhanVienService.tongLuong();
        return ResponseEntity.ok().body(tong);
    }


}
