package com.example.stream.buoi2.controller;

import com.example.stream.buoi2.entity.SinhVien;
import com.example.stream.buoi2.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sinhvien")
public class SinhVienController {

    @Autowired
    SinhVienService sinhVienService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<SinhVien> getAll = sinhVienService.getAll();
        return ResponseEntity.ok(getAll);
    }

    @GetMapping("/diemcao")
    public ResponseEntity<?> diemCao() {
        Optional<SinhVien> diemCao = sinhVienService.dienCao();
        return ResponseEntity.ok(diemCao);
    }

    @GetMapping("/diemtb")
    public ResponseEntity<?> diemTB() {
        double diemTB = sinhVienService.diemTB();
        return ResponseEntity.ok(diemTB);
    }

    @GetMapping("/locsv")
    public ResponseEntity<?> locSV() {
        List<SinhVien> locSV = sinhVienService.locSV();
        return ResponseEntity.ok(locSV);
    }

    @GetMapping("/sapxep")
    public ResponseEntity<?> sapxep() {
        List<SinhVien> sapXep = sinhVienService.sapXep();
        return ResponseEntity.ok(sapXep);
    }

    @GetMapping("/diem5")
    public ResponseEntity<?> diem5() {
        List<SinhVien> diem5 = sinhVienService.diem5();
        return ResponseEntity.ok(diem5);
    }


}
