package com.example.template.controller;


import com.example.template.dao.PhieuGiaoHangCustom;
import com.example.template.dao.PhieuGiaoHangRequest;
import com.example.template.model.PhieuGiaoHang;
import com.example.template.service.PhieuGiaoHangService;
import jakarta.validation.Valid;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/phieugiao")
public class PhieuGiaoHangController {

    @Autowired
    private PhieuGiaoHangService phieuGiaoHangService;

    @GetMapping("/index")
    public ResponseEntity<?> getAll() {
        List<PhieuGiaoHangCustom> getAll = phieuGiaoHangService.getAll();
        return ResponseEntity.ok().body(getAll);
    }

    @GetMapping("/phantrang")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> findAll = phieuGiaoHangService.findAll(pageable);
        return ResponseEntity.ok().body(findAll);
    }

    @GetMapping("/detail/{maPhieuGiao}")
    public ResponseEntity<?> detail(@PathVariable("maPhieuGiao") UUID maPhieuGiao) {
        PhieuGiaoHang detail = phieuGiaoHangService.getOne(maPhieuGiao);
        return ResponseEntity.ok().body(detail);
    }

    @DeleteMapping("/delete/{maPhieuGiao}")
    public ResponseEntity<?> delete(@PathVariable("maPhieuGiao") UUID maPhieuGiao) {
        boolean delete = phieuGiaoHangService.delete(maPhieuGiao);
        return ResponseEntity.ok().body(delete);
    }

    @PutMapping("/update/{maPhieuGiao}")
    public ResponseEntity<?> update(@Valid @PathVariable("maPhieuGiao") UUID maPhieuGiao, @RequestBody PhieuGiaoHangRequest request) {
        PhieuGiaoHang update = phieuGiaoHangService.update(maPhieuGiao, request);
        return ResponseEntity.ok().body(update);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody PhieuGiaoHangRequest request) {
        PhieuGiaoHang add = phieuGiaoHangService.add(request);
        return ResponseEntity.ok().body(add);
    }

    @GetMapping("/loc")
    public ResponseEntity<?> loc() {
        List<PhieuGiaoHang> loc = phieuGiaoHangService.loc();
        return ResponseEntity.ok().body(loc);
    }


    @GetMapping("/phicao")
    public ResponseEntity<?> phiCao() {
        Optional<PhieuGiaoHang> phiCao = phieuGiaoHangService.phiCao();
        return ResponseEntity.ok().body(phiCao);
    }

    @GetMapping("/count")
    public ResponseEntity<?> count() {
        double dem = phieuGiaoHangService.count();
        return ResponseEntity.ok().body(dem);
    }


    @GetMapping("/sort")
    public ResponseEntity<?> sort() {
    Stream<PhieuGiaoHang> sort=   phieuGiaoHangService.sort();
        return ResponseEntity.ok().body(sort);
    }

}
