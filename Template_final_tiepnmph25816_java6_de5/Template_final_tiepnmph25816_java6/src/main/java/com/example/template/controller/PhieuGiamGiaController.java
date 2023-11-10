package com.example.template.controller;


import com.example.template.dao.PhieuGiamGiaCustom;
import com.example.template.dao.PhieuGiamGiaRequest;
import com.example.template.model.PhieuGiamGia;
import com.example.template.service.PhieuGiamGiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

@RestController
@RequestMapping("/api/phieugiamgia")
public class PhieuGiamGiaController {

    @Autowired
    private PhieuGiamGiaService phieuGiamGiaService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<PhieuGiamGiaCustom> getAll = phieuGiamGiaService.getAll();
        return ResponseEntity.ok().body(getAll);
    }

    @GetMapping("/index")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,2);
        Page<PhieuGiamGia> findAll = phieuGiamGiaService.findAll(pageable);
        return ResponseEntity.ok().body(findAll);
    }

    @GetMapping("/detail/{maPhieu}")
    public ResponseEntity<?> detail(@PathVariable("maPhieu") String maPhieu) {
        PhieuGiamGia detail = phieuGiamGiaService.getOne(maPhieu);
        return ResponseEntity.ok().body(detail);
    }


    @DeleteMapping("/delete/{maPhieu}")
    public ResponseEntity<?> delete(@PathVariable("maPhieu") String maPhieu) {
        boolean delete = phieuGiamGiaService.delete(maPhieu);
        return ResponseEntity.ok().body(delete);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody PhieuGiamGiaRequest request)  {
        PhieuGiamGia add = phieuGiamGiaService.add(request);
        return ResponseEntity.ok().body(add);
    }

    @PutMapping("/update/{maPhieu}")
    public ResponseEntity<?> update(@PathVariable("maPhieu") String maPhieu, @RequestBody PhieuGiamGiaRequest request) {
        PhieuGiamGia update = phieuGiamGiaService.update(maPhieu, request);
        return ResponseEntity.ok().body(update);
    }

    @GetMapping("/count")
    public ResponseEntity<?> count(){
        double count = phieuGiamGiaService.count();
        return ResponseEntity.ok().body(count);
    }
}
