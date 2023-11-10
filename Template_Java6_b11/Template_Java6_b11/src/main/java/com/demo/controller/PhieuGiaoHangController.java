package com.demo.controller;

import com.demo.model.HoaDon;
import com.demo.model.PhieuGiaoHang;
import com.demo.service.HoaDonService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/phieugiaohang")
public class PhieuGiaoHangController {

    @Autowired
    PhieuGiaoHangService phieuGiaoHangService;

    @Autowired
    HoaDonService hoaDonService;

    @GetMapping()
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page) {
        hoaDonService.getAll();
        Pageable pageable = PageRequest.of(page, 5);
        Page<PhieuGiaoHang> getAll = phieuGiaoHangService.getAll(pageable);
        return ResponseEntity.ok().body(getAll);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody PhieuGiaoHang phieuGiaoHang) {
        HoaDon hoaDon = hoaDonService.findByID(phieuGiaoHang.getHoaDon().getMaHoaDon());
        phieuGiaoHang.setHoaDon(hoaDon);
        PhieuGiaoHang add = phieuGiaoHangService.add(phieuGiaoHang);
        return ResponseEntity.ok().body(add);
    }

    @DeleteMapping("/delete/{maPhieuGiao}")
    public ResponseEntity<?> delete(@PathVariable("maPhieuGiao") UUID maPhieuGiao) {
        phieuGiaoHangService.delete(maPhieuGiao);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{maPhieuGiao}")
    public ResponseEntity<?> update(@Valid @PathVariable("maPhieuGiao") UUID maPhieuGiao, @RequestBody PhieuGiaoHang phieuGiaoHang) {
        HoaDon hoaDon = hoaDonService.findByID(phieuGiaoHang.getHoaDon().getMaHoaDon());
        phieuGiaoHang.setHoaDon(hoaDon);
        PhieuGiaoHang update = phieuGiaoHangService.update(maPhieuGiao, phieuGiaoHang);
        return ResponseEntity.ok().body(update);
    }

    @GetMapping("/lochd")
    public ResponseEntity<?> locHoaDon() {
        hoaDonService.getAll();
        List<PhieuGiaoHang> locHD = phieuGiaoHangService.locHoaDon();
        return ResponseEntity.ok().body(locHD);
    }


    @GetMapping("/hoadoncao")
    public ResponseEntity<?> hoaDonCao() {
        hoaDonService.getAll();
        Optional<PhieuGiaoHang> hoaDonCao = phieuGiaoHangService.hoaDonCao();
        return ResponseEntity.ok().body(hoaDonCao);
    }

    @GetMapping("/timkiem")
    public ResponseEntity<?> timNguoi() {
        hoaDonService.getAll();
        List<PhieuGiaoHang> timKiem = phieuGiaoHangService.timKiem();
        return ResponseEntity.ok().body(timKiem);
    }

    @GetMapping("/tbc")
    public ResponseEntity<?> tbc() {
        hoaDonService.getAll();
        double tbc = phieuGiaoHangService.tbc();
        return ResponseEntity.ok().body(tbc);
    }

    @GetMapping("/sort")
    public ResponseEntity<?> sort() {
        hoaDonService.getAll();
        List<PhieuGiaoHang> sort= phieuGiaoHangService.sapXep();
        return ResponseEntity.ok().body(sort);
    }

    @GetMapping("/tbp")
    public ResponseEntity<?> tbp() {
        hoaDonService.getAll();
        double tbp = phieuGiaoHangService.tongBinhPhuong();
        return ResponseEntity.ok().body(tbp);
    }

    @GetMapping("/tongphi")
    public ResponseEntity<?> tongPhi() {
        hoaDonService.getAll();
        double tongPhi = phieuGiaoHangService.tongPhiGiaoHang();
        return ResponseEntity.ok().body(tongPhi);
    }
}

