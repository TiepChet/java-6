package com.example.restapi.service.impl;

import com.example.restapi.exception.ResourceNotFoundException;
import com.example.restapi.model.HangKhachHang;
import com.example.restapi.repository.HangKhachHangRepo;
import com.example.restapi.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HangKhachHangServiceImpl implements HangKhachHangService {

    @Autowired
    HangKhachHangRepo hangKhachHangRepo;

    @Override
    public List<HangKhachHang> getAll() {
        return hangKhachHangRepo.findAll();
    }

    @Override
    public HangKhachHang getOne(int maHang) throws ResourceNotFoundException {
        Optional<HangKhachHang> findID = hangKhachHangRepo.findById(maHang);
        if (findID.isPresent()) {
            return findID.get();
        }
        throw new ResourceNotFoundException("HangKH not found with id: " + maHang);
    }

    @Override
    public HangKhachHang add(HangKhachHang hangKhachHang) {
        return hangKhachHangRepo.save(hangKhachHang);
    }

    @Override
    public HangKhachHang update(int maHang, HangKhachHang hangKhachHang) throws ResourceNotFoundException {
        Optional<HangKhachHang> findID = hangKhachHangRepo.findById(maHang);
        if (findID.isPresent()) {
            HangKhachHang updateHKH = findID.get();
            updateHKH.setTenHang(hangKhachHang.getTenHang());
            updateHKH.setMoTa(hangKhachHang.getMoTa());
            updateHKH.setDiemToiThieu(hangKhachHang.getDiemToiThieu());
            updateHKH.setTrangThai(hangKhachHang.getTrangThai());
            return hangKhachHangRepo.save(updateHKH);
        }
        throw new ResourceNotFoundException("HangKH not found with id: " + maHang);
    }

    @Override
    public void delete(int maHang) {
        hangKhachHangRepo.deleteById(maHang);
    }

    @Override
    public List<HangKhachHang> search(String tenHang) {
        return hangKhachHangRepo.search("%" + tenHang + "%");
    }
}
