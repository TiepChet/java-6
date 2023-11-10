package com.demo.service;

import com.demo.model.PhieuGiaoHang;
import com.demo.repository.PhieuGiaoHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class PhieuGiaoHangService {

    @Autowired
    PhieuGiaoHangRepo phieuGiaoHangRepo;

    public Page<PhieuGiaoHang> getAll(Pageable pageable) {
        return phieuGiaoHangRepo.findAll(pageable);
    }

    public PhieuGiaoHang add(PhieuGiaoHang phieuGiaoHang) {
        return phieuGiaoHangRepo.save(phieuGiaoHang);
    }

    public PhieuGiaoHang update(UUID maPhieuGiao, PhieuGiaoHang phieuGiaoHang) {
        PhieuGiaoHang updatePGH = phieuGiaoHangRepo.findById(maPhieuGiao).get();
        updatePGH.setPhiGiaoHang(phieuGiaoHang.getPhiGiaoHang());
        updatePGH.setHoaDon(phieuGiaoHang.getHoaDon());
        updatePGH.setNguoiNhan(phieuGiaoHang.getNguoiNhan());
        updatePGH.setSoDienThoai(phieuGiaoHang.getSoDienThoai());
        return phieuGiaoHangRepo.save(updatePGH);
    }

    public void delete(UUID maPhieuGiao) {
        phieuGiaoHangRepo.deleteById(maPhieuGiao);
    }

    public List<PhieuGiaoHang> locHoaDon() {
        return phieuGiaoHangRepo.findAll().stream().filter(o -> o.getPhiGiaoHang() >= 5000 && o.getPhiGiaoHang() <= 7000).collect(Collectors.toList());
    }

    public Optional<PhieuGiaoHang> hoaDonCao() {
        return phieuGiaoHangRepo.findAll().stream().max(Comparator.comparing(PhieuGiaoHang::getPhiGiaoHang));
    }

    public List<PhieuGiaoHang> timKiem() {
        return phieuGiaoHangRepo.findAll().stream().filter(o -> o.getNguoiNhan().equals("Trần Lâm Tới")).collect(Collectors.toList());

    }

    public double tbc() {
        return phieuGiaoHangRepo.findAll().stream().mapToDouble(PhieuGiaoHang::getPhiGiaoHang).average().orElse(0.0);
    }

    public List<PhieuGiaoHang> sapXep() {
        return phieuGiaoHangRepo.sapXep();
    }

    public double tongBinhPhuong() {
        return phieuGiaoHangRepo.findAll().stream().mapToDouble(phiGiaoHang -> Math.pow(phiGiaoHang.getPhiGiaoHang(), 2)).sum();
    }

    public double tongPhiGiaoHang() {
        return phieuGiaoHangRepo.findAll().stream().mapToDouble(PhieuGiaoHang::getPhiGiaoHang).sum();
    }

}
