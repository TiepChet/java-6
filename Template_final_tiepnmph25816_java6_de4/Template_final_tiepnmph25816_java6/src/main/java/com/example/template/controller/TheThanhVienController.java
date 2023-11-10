package com.example.template.controller;

import com.example.template.dao.TheThanhVienCustom;
import com.example.template.dao.TheThanhVienRequest;
import com.example.template.model.TheThanhVien;
import com.example.template.service.TheThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/thethanhvien")
public class TheThanhVienController {

    @Autowired
    TheThanhVienService theThanhVienService;

    @GetMapping("/index")
    public ResponseEntity<?> getAll() {
        List<TheThanhVienCustom> getAll = theThanhVienService.getAll();
        return ResponseEntity.ok().body(getAll);
    }

    @GetMapping("/detail/{maThe}")
    public ResponseEntity<?> detail(@PathVariable("maThe") String maThe) {
        TheThanhVien detail = theThanhVienService.getOne(maThe);
        return ResponseEntity.ok().body(detail);
    }

    @DeleteMapping("/delete/{maThe}")
    public ResponseEntity<?> delete(@PathVariable("maThe") String maThe) {
        boolean delete = theThanhVienService.delete(maThe);
        return ResponseEntity.ok().body(delete);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody TheThanhVienRequest request) {
        TheThanhVien add = theThanhVienService.add(request);
        return ResponseEntity.ok().body(add);
    }

    @PutMapping("/update/{maThe}")
    public ResponseEntity<?> update(@PathVariable("maThe") String maThe, @RequestBody TheThanhVienRequest request) {
        TheThanhVien update = theThanhVienService.update(maThe, request);
        return ResponseEntity.ok().body(update);
    }
}
