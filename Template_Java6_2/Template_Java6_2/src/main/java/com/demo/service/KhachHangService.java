package com.demo.service;

import com.demo.dao.KhachHangCustom;
import com.demo.dao.KhachHangRequest;
import com.demo.model.HangKhachHang;
import com.demo.model.KhachHang;
import com.demo.repository.HangKhachHangRepo;
import com.demo.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class KhachHangService {

    @Autowired
    KhachHangRepo khachHangRepo;

    @Autowired
    HangKhachHangRepo hangKhachHangRepo;

    public Page<KhachHangCustom> getAll(Pageable pageable){
        return khachHangRepo.getAll(pageable);
    }

    public KhachHang getOne(Long maKhachHang) {
        return khachHangRepo.findById(maKhachHang).get();
    }

    public void delete(Long maKhachHang) {
        khachHangRepo.deleteById(maKhachHang);
    }

    public KhachHang update(Long maKhachHang, KhachHangRequest khachHangRequest) {
        KhachHang updateKH = khachHangRepo.findById(maKhachHang).get();
        updateKH.setHangKhachHang(HangKhachHang.builder().maHang(khachHangRequest.getMaHang()).tenHang(khachHangRequest.getTenHang()).build());
        updateKH.setTenKhachHang(khachHangRequest.getTenKhachHang());
        updateKH.setSoDienThoai(khachHangRequest.getSoDienThoai());
        updateKH.setGioiTinh(khachHangRequest.isGioiTinh());
        return khachHangRepo.save(updateKH);
    }

    public KhachHang add( KhachHangRequest khachHangRequest) {
        KhachHang addKH = new KhachHang();
        addKH.setHangKhachHang(HangKhachHang.builder().maHang(khachHangRequest.getMaHang()).tenHang(khachHangRequest.getTenHang()).build());
        addKH.setTenKhachHang(khachHangRequest.getTenKhachHang());
        addKH.setSoDienThoai(khachHangRequest.getSoDienThoai());
        addKH.setGioiTinh(khachHangRequest.isGioiTinh());
        return khachHangRepo.save(addKH);
    }

    public List<KhachHang> loc(){
        return khachHangRepo.findAll().stream().filter(o->o.getTenKhachHang().equals("Nguyễn Mạnh Tiệp")).collect(Collectors.toList());
    }

}
