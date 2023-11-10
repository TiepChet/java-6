package com.example.demo.Buoi4.controller;


import com.example.demo.Buoi4.dto.ChiTietSPRequest;
import com.example.demo.Buoi4.entity.ChiTietSanPham;
import com.example.demo.Buoi4.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chitietsp")
public class ChiTietSpController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @GetMapping("/index")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(chiTietSPService.getAll());
    }

    @GetMapping("/detail/{ma}")
    public ResponseEntity<?> getOne(@PathVariable String ma){
        return ResponseEntity.ok(chiTietSPService.getOne(ma));
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@PathVariable String ma, @RequestBody ChiTietSPRequest request){
        return ResponseEntity.ok(chiTietSPService.update(ma,request));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add( @RequestBody ChiTietSPRequest request){
        return ResponseEntity.ok(chiTietSPService.add(request));
    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> delete(@PathVariable String ma){
        return ResponseEntity.ok(chiTietSPService.delete(ma));
    }
}
