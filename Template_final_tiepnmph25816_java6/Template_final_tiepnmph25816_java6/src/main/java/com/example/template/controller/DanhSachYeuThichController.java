package com.example.template.controller;


import com.example.template.dao.DanhSachYeuThichCustom;
import com.example.template.dao.DanhSachYeuThichRequest;
import com.example.template.model.DanhSachYeuThich;
import com.example.template.service.DanhSachYeuThichService;
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
import java.util.UUID;

@RestController
@RequestMapping("/api/danhsach")
public class DanhSachYeuThichController {

    @Autowired
    DanhSachYeuThichService danhSachYeuThichService;

    @GetMapping("/index")
    public ResponseEntity<?> hienThi() {
        List<DanhSachYeuThichCustom> getAll = danhSachYeuThichService.getAll();
        return ResponseEntity.ok().body(getAll);
    }

    @GetMapping("/phantrang")
    public ResponseEntity<?> phanTrang(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 1);
        Page<DanhSachYeuThich> phanTrang = danhSachYeuThichService.findAll(pageable);
        return ResponseEntity.ok().body(phanTrang);
    }

    @GetMapping("/detail/{maDanhSach}")
    public ResponseEntity<?> detail(@PathVariable("maDanhSach") UUID maDanhSach) {
        DanhSachYeuThich detail = danhSachYeuThichService.getOne(maDanhSach);
        return ResponseEntity.ok().body(detail);
    }


    @DeleteMapping("/delete/{maDanhSach}")
    public ResponseEntity<?> delete(@PathVariable("maDanhSach") UUID maDanhSach) {
      boolean delete=  danhSachYeuThichService.delete(maDanhSach);
        return ResponseEntity.ok().body(delete);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody DanhSachYeuThichRequest request) {
        DanhSachYeuThich danhSachYeuThich = danhSachYeuThichService.add(request);
        return ResponseEntity.ok().body(danhSachYeuThich);
    }

    @PutMapping("/update/{maDanhSach}")
    public ResponseEntity<?> update(@PathVariable("maDanhSach") UUID maDanhSach, @RequestBody DanhSachYeuThichRequest request) {
        DanhSachYeuThich update = danhSachYeuThichService.update(maDanhSach,request);
        return ResponseEntity.ok().body(update);
    }
}
