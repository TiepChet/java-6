package com.example.restapi.controller;

import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.model.HangKhachHang;
import com.example.restapi.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class HangKhachHangController {

    @Autowired
    HangKhachHangService hangKhachHangService;

    @GetMapping("/index")
    public ResponseEntity<List<HangKhachHang>> hienThi() {
        List<HangKhachHang> hangKhachHangs = hangKhachHangService.getAll();
        return ResponseEntity.ok().body(hangKhachHangs);
    }

    @PostMapping("/add")
    public ResponseEntity<HangKhachHang> add(@RequestBody HangKhachHang hangKhachHang) {
        HangKhachHang hangKhachHangs = hangKhachHangService.add(hangKhachHang);
        return ResponseEntity.ok().body(hangKhachHangs);
    }

    @GetMapping("/search")
    public ResponseEntity<List<HangKhachHang>> hienThi(@RequestParam("tenHang") String tenHang) {
        List<HangKhachHang> hangKhachHangs = hangKhachHangService.search(tenHang);
        return ResponseEntity.ok().body(hangKhachHangs);
    }

    @DeleteMapping("/delete/{maHang}")
    public ResponseEntity<?> hienThi(@PathVariable("maHang") int maHang) {
        hangKhachHangService.delete(maHang);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{maHang}")
    public ResponseEntity<HangKhachHang> update(@RequestBody HangKhachHang hangKhachHang,
                                                @PathVariable("maHang") int maHang) throws ResourceNotFoundException {
        HangKhachHang hangKhachHangs = hangKhachHangService.update(maHang, hangKhachHang);
        return ResponseEntity.ok().body(hangKhachHangs);
    }

    @GetMapping("/{maHang}")
    public ResponseEntity<HangKhachHang> getOne(@PathVariable("maHang") int maHang) throws ResourceNotFoundException {
        HangKhachHang hangKhachHangs = hangKhachHangService.getOne(maHang);
        return ResponseEntity.ok().body(hangKhachHangs);
    }
}
