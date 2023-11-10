package com.example.demo.controller;

import com.example.demo.entity.SinhVien;
import com.example.demo.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SinhVienController {

    @Autowired
    SinhVienService sinhVienService;

    @GetMapping("/hien-thi")
    public ResponseEntity<List<SinhVien>> getAll(){
        List<SinhVien> getAll= sinhVienService.getAll();
        return ResponseEntity.ok().body(getAll);
    }

    @GetMapping("/diem")
    public ResponseEntity<?> diem(){
        sinhVienService.getAll();
        Optional<SinhVien> diemCao= sinhVienService.diemCao();
        return ResponseEntity.ok().body(diemCao);
    }

    @GetMapping("/diemTB")
    public ResponseEntity<?> diemTB(){
        sinhVienService.getAll();
        double diemTB= sinhVienService.dtb();
        System.out.println(diemTB);
        return ResponseEntity.ok().body(diemTB);
    }

    @GetMapping("/loc-tuoi")
    public ResponseEntity<?> locTuoi(){
        sinhVienService.getAll();
        List<SinhVien> tuoi= sinhVienService.loc();
        return ResponseEntity.ok().body(tuoi);
    }

    @GetMapping("/tongbp")
    public ResponseEntity<?> tongBP(){
        sinhVienService.getAll();
        double tongBP= sinhVienService.tongBP();
        return ResponseEntity.ok().body(tongBP);
    }

    @GetMapping("/sap-xep")
    public ResponseEntity<?> sapXep(){
        sinhVienService.getAll();
        List<SinhVien> sapXep= sinhVienService.sapXep();
        return ResponseEntity.ok().body(sapXep);
    }

    @GetMapping("/diem5")
    public ResponseEntity<?> diem5(){
        sinhVienService.getAll();
        List<SinhVien> diem5= sinhVienService.diem5();
        return ResponseEntity.ok().body(diem5);
    }
}
