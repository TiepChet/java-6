package com.demo.controller;

import com.demo.dao.KhachHangCustom;
import com.demo.dao.KhachHangRequest;
import com.demo.model.KhachHang;
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
import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {

    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/index")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHangCustom> getAll = khachHangService.getAll(pageable);
        return ResponseEntity.ok(getAll);
    }


    @GetMapping("/detail/{maKhachHang}")
    public ResponseEntity<?> detail(@PathVariable("maKhachHang") long maKhachHang) {
        KhachHang detail = khachHangService.getOne(maKhachHang);
        return ResponseEntity.ok(detail);
    }

    @DeleteMapping("/delete/{maKhachHang}")
    public ResponseEntity<?> delete(@PathVariable("maKhachHang") long maKhachHang) {
        khachHangService.delete(maKhachHang);
        return ResponseEntity.ok().build();
    }



    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody KhachHangRequest khachHangRequest) {
        KhachHang add = khachHangService.add(khachHangRequest);
        return ResponseEntity.ok(add);
    }

    @GetMapping("/loc")
    public ResponseEntity<?> loc() {
        List<KhachHang> loc = khachHangService.loc();
        return ResponseEntity.ok(loc);
    }


}
