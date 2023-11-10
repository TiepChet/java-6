package com.example.template.service;

import com.example.template.dao.PhieuGiaoHangCustom;
import com.example.template.dao.PhieuGiaoHangRequest;
import com.example.template.model.HoaDon;
import com.example.template.model.PhieuGiaoHang;
import com.example.template.repository.PhieuGiaoHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PhieuGiaoHangService {

    @Autowired
    PhieuGiaoHangRepo phieuGiaoHangRepo;


    public List<PhieuGiaoHangCustom> getAll() {
        return phieuGiaoHangRepo.getAll();
    }

    public Page<PhieuGiaoHang> findAll(Pageable pageable) {
        return phieuGiaoHangRepo.findAll(pageable);
    }


    public PhieuGiaoHang getOne(UUID maPhieuGiao) {
        return phieuGiaoHangRepo.findById(maPhieuGiao).get();
    }


    public boolean delete(UUID maPhieuGiao) {
        phieuGiaoHangRepo.deleteById(maPhieuGiao);
        return true;
    }

    public PhieuGiaoHang add(PhieuGiaoHangRequest request) {
        PhieuGiaoHang phieuGiaoHang = new PhieuGiaoHang();
        phieuGiaoHang.setPhiGiaoHang(request.getPhiGiaoHang());
        phieuGiaoHang.setSdtNhan(request.getSdtNhan());
        phieuGiaoHang.setNguoiNhan(request.getNguoiNhan());
        phieuGiaoHang.setHoaDon(HoaDon.builder().maHoaDon(request.getMaHoaDon()).nguoiLap(request.getNguoiLap()).ghiChu(request.getGhiChu()).build());
        return phieuGiaoHangRepo.save(phieuGiaoHang);
    }

    public PhieuGiaoHang update(UUID maPhieuGiao, PhieuGiaoHangRequest request) {
        PhieuGiaoHang phieuGiaoHang = phieuGiaoHangRepo.findById(maPhieuGiao).get();
        phieuGiaoHang.setPhiGiaoHang(request.getPhiGiaoHang());
        phieuGiaoHang.setSdtNhan(request.getSdtNhan());
        phieuGiaoHang.setNguoiNhan(request.getNguoiNhan());
        phieuGiaoHang.setHoaDon(HoaDon.builder().maHoaDon(request.getMaHoaDon()).nguoiLap(request.getNguoiLap()).ghiChu(request.getGhiChu()).build());
        return phieuGiaoHangRepo.save(phieuGiaoHang);
    }

    public List<PhieuGiaoHang> loc() {
        return phieuGiaoHangRepo.findAll().stream().filter(o -> o.getPhiGiaoHang() >= 2000 && o.getPhiGiaoHang() <= 2300).collect(Collectors.toList());
    }

    public Optional<PhieuGiaoHang> phiCao(){
        return phieuGiaoHangRepo.findAll().stream().max(Comparator.comparing(PhieuGiaoHang::getPhiGiaoHang));

    }

    public double count(){
        return phieuGiaoHangRepo.findAll().stream().filter(o->o.getPhiGiaoHang()==2000).count();
    }

    public Stream<PhieuGiaoHang> sort(){
        return phieuGiaoHangRepo.findAll().stream().sorted(Comparator.comparing(PhieuGiaoHang::getPhiGiaoHang,Comparator.reverseOrder()));
    }

    public double sum(){
        return phieuGiaoHangRepo.findAll().stream().mapToDouble(PhieuGiaoHang::getPhiGiaoHang).sum();
    }

    public double avg(){
        return phieuGiaoHangRepo.findAll().stream().mapToDouble(PhieuGiaoHang::getPhiGiaoHang).average().orElse(0.0);
    }

    public double tbc(){
        return phieuGiaoHangRepo.findAll().stream().mapToDouble(tbc->Math.pow(tbc.getPhiGiaoHang(),2)).sum();
    }

}
