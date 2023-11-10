package com.demo.service;

import com.demo.dao.PhieuGiaoHangCustom;
import com.demo.dao.PhieuGiaoHangRequest;
import com.demo.model.HoaDon;
import com.demo.model.PhieuGiaoHang;
import com.demo.repository.PhieuGiaoHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhieuGiaoHangService {

    @Autowired
    PhieuGiaoHangRepo phieuGiaoHangRepo;

    public Page<PhieuGiaoHangCustom> getAll(Pageable pageable) {
        return phieuGiaoHangRepo.getAll(pageable);
    }

    public void delete(String maPhieuGiao) {
        phieuGiaoHangRepo.deleteById(maPhieuGiao);
    }

    public PhieuGiaoHang getOne(String maPhieuGiao) {
        Optional<PhieuGiaoHang> optional = phieuGiaoHangRepo.findById(maPhieuGiao);
        return optional.isPresent() ? optional.get() : null;
    }

    public PhieuGiaoHang add(PhieuGiaoHangRequest request) {

        PhieuGiaoHang phieuGiaoHang = new PhieuGiaoHang();
        phieuGiaoHang.setHoaDon(HoaDon.builder().maHoaDon(request.getMaHoaDon()).nguoiLap(request.getNguoiLap()).ghiChu(request.getGhiChu()).build());
        phieuGiaoHang.setNguoiNhan(request.getNguoiNhan());
        phieuGiaoHang.setSoDienThoai(request.getSdtNhan());
        phieuGiaoHang.setPhiGiaoHang(request.getPhiGiaoHang());
        return phieuGiaoHangRepo.save(phieuGiaoHang);
    }



}
