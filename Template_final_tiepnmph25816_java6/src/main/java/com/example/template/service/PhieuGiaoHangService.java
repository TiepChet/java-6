package com.example.template.service;

import com.example.template.dao.PhieuGiaoHangCustom;
import com.example.template.dao.PhieuGiaoHangRequest;
import com.example.template.model.HoaDon;
import com.example.template.model.PhieuGiaoHang;
import com.example.template.repository.PhieuGiaoHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhieuGiaoHangService {

    @Autowired
    PhieuGiaoHangRepo phieuGiaoHangRepo;

    public List<PhieuGiaoHangCustom> hienThi() {
        return phieuGiaoHangRepo.getAll();
    }

    public PhieuGiaoHang getOne(UUID maPhieuGiao) {
        return phieuGiaoHangRepo.findById(maPhieuGiao).get();
    }

    public PhieuGiaoHang add(PhieuGiaoHangRequest request) {
        PhieuGiaoHang phieuGiaoHang = new PhieuGiaoHang();
        phieuGiaoHang.setPhiGiaoHang(request.getPhiGiaoHang());
        phieuGiaoHang.setNguoiNhan(request.getNguoiNhan());
        phieuGiaoHang.setSdtNhan(request.getSdtNhan());
        phieuGiaoHang.setHoaDon(HoaDon.builder().nguoiLap(request.getNguoiLap()).ghiChu(request.getGhiChu()).build());
        return phieuGiaoHangRepo.save(phieuGiaoHang);
    }


    public PhieuGiaoHang update(UUID maPhieuGiao, PhieuGiaoHangRequest request) {
        PhieuGiaoHang phieuGiaoHang= phieuGiaoHangRepo.findById(maPhieuGiao).get();
        phieuGiaoHang.setPhiGiaoHang(request.getPhiGiaoHang());
        phieuGiaoHang.setNguoiNhan(request.getNguoiNhan());
        phieuGiaoHang.setSdtNhan(request.getSdtNhan());
        phieuGiaoHang.setHoaDon(HoaDon.builder().nguoiLap(request.getNguoiLap()).ghiChu(request.getGhiChu()).build());
        return phieuGiaoHangRepo.save(phieuGiaoHang);
    }
}
