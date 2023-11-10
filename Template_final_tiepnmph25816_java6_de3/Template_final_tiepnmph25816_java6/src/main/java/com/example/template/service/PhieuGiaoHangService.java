package com.example.template.service;


import com.example.template.dao.PhieuGiaoHangCustom;
import com.example.template.dao.PhieuGiaoHangRequest;
import com.example.template.model.DiaChi;
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
    private PhieuGiaoHangRepo phieuGiaoHangRepo;

    public List<PhieuGiaoHangCustom> getAll() {
        return phieuGiaoHangRepo.getAll();
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
        phieuGiaoHang.setNguoiNhan(request.getNguoiNhan());
        phieuGiaoHang.setSdtNhan(request.getSdtNhan());
        phieuGiaoHang.setHoaDon(HoaDon.builder().maHoaDon(request.getMaHoaDon()).nguoiLap(request.getNguoiLap()).build());
        phieuGiaoHang.setDiaChi(DiaChi.builder().maDiaChi(request.getMaDiaChi()).tenDiaChi(request.getTenDiaChi()).moTaChiTiet(request.getMoTaChiTiet()).build());
        return phieuGiaoHangRepo.save(phieuGiaoHang);
    }
}
