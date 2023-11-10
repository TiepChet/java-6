package com.demo.controller;

import com.demo.dao.PhieuGiaoHangCustom;
import com.demo.dao.PhieuGiaoHangRequest;
import com.demo.model.PhieuGiaoHang;
import com.demo.service.PhieuGiaoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/phieugiaohang")
public class PhieuGiaoHangController {

    @Autowired
    PhieuGiaoHangService phieuGiaoHangService;

    @GetMapping("/index")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHangCustom> getAll = phieuGiaoHangService.getAll(pageable);
        return ResponseEntity.ok(getAll);
    }

    @GetMapping("/detail/{maPhieuGiao}")
    public ResponseEntity<?> detail(@PathVariable("maPhieuGiao") String maPhieuGiao) {
        PhieuGiaoHang getOne = phieuGiaoHangService.getOne(maPhieuGiao);
        return ResponseEntity.ok().body(getOne);
    }

    @DeleteMapping("/delete/{maPhieuGiao}")
    public ResponseEntity<?> delete(@PathVariable("maPhieuGiao") String maPhieuGiao) {
        phieuGiaoHangService.delete(maPhieuGiao);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PhieuGiaoHangRequest request) {
        PhieuGiaoHang add = phieuGiaoHangService.add(request);
        return ResponseEntity.ok(add);
    }

}
