package com.example.template.service;

import com.example.template.dao.TheThanhVienCustom;
import com.example.template.dao.TheThanhVienRequest;
import com.example.template.model.KhachHang;
import com.example.template.model.TheThanhVien;
import com.example.template.repository.TheThanhVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class TheThanhVienService {

    @Autowired
    TheThanhVienRepo theThanhVienRepo;

    public List<TheThanhVienCustom> getAll() {
        return theThanhVienRepo.getAll();
    }

    public TheThanhVien getOne(String maThe) {
        return theThanhVienRepo.findById(maThe).get();
    }

    public boolean delete(String maThe) {
        theThanhVienRepo.deleteById(maThe);
        return true;
    }

    public TheThanhVien add(TheThanhVienRequest request) {

        TheThanhVien theThanhVien = new TheThanhVien();
        theThanhVien.setMaThe(request.getMaThe());
        theThanhVien.setLoaiThe(request.getLoaiThe());
        theThanhVien.setMauThe(request.getMauThe());
        theThanhVien.setNgayPhatHanh(request.getNgayPhatHanh());
        theThanhVien.setKhachHang(KhachHang.builder().maKhachHang(request.getMaKhachHang()).tenKhachHang(request.getTenKhachHang()).build());
        return theThanhVienRepo.save(theThanhVien);
    }


    public TheThanhVien update(String maThe, TheThanhVienRequest request) {

        TheThanhVien theThanhVien = theThanhVienRepo.findById(maThe).get();
        theThanhVien.setMaThe(request.getMaThe());
        theThanhVien.setLoaiThe(request.getLoaiThe());
        theThanhVien.setMauThe(request.getMauThe());
        theThanhVien.setNgayPhatHanh(request.getNgayPhatHanh());
        theThanhVien.setKhachHang(KhachHang.builder().maKhachHang(request.getMaKhachHang()).tenKhachHang(request.getTenKhachHang()).build());
        return theThanhVienRepo.save(theThanhVien);
    }
}
