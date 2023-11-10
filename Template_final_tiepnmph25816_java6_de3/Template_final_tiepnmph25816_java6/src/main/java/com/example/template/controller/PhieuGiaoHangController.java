package com.example.template.controller;

import com.example.template.dao.PhieuGiaoHangCustom;
import com.example.template.dao.PhieuGiaoHangRequest;
import com.example.template.model.PhieuGiaoHang;
import com.example.template.service.PhieuGiaoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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


    @GetMapping("/detail/{maPhieuGiao}")
    public ResponseEntity<?> detail(@PathVariable("maPhieuGiao")UUID maPhieuGiao) {
        PhieuGiaoHang detail = phieuGiaoHangService.getOne(maPhieuGiao);
        return ResponseEntity.ok().body(detail);
    }

    @DeleteMapping("/delete/{maPhieuGiao}")
    public ResponseEntity<?> delete(@PathVariable("maPhieuGiao")UUID maPhieuGiao) {
        boolean delete = phieuGiaoHangService.delete(maPhieuGiao);
        return ResponseEntity.ok().body(delete);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PhieuGiaoHangRequest request){
        PhieuGiaoHang add = phieuGiaoHangService.add(request);
        return ResponseEntity.ok().body(add);
    }
}
