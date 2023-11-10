package com.example.template.service;

import com.example.template.dao.PhieuGiamGiaCustom;
import com.example.template.dao.PhieuGiamGiaRequest;
import com.example.template.model.KhachHang;
import com.example.template.model.PhieuGiamGia;
import com.example.template.repository.PhieuGiamGiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PhieuGiamGiaService {

    @Autowired
    PhieuGiamGiaRepo phieuGiamGiaRepo;

    public List<PhieuGiamGiaCustom> getAll() {
        return phieuGiamGiaRepo.getAll();
    }

    public Page<PhieuGiamGia> findAll(Pageable pageable) {
        return phieuGiamGiaRepo.findAll(pageable);
    }

    public PhieuGiamGia getOne(String maPhieu) {
        return phieuGiamGiaRepo.findById(maPhieu).get();
    }

    public boolean delete(String maPhieu) {
        phieuGiamGiaRepo.deleteById(maPhieu);
        return true;
    }

    public PhieuGiamGia add(PhieuGiamGiaRequest request){
        PhieuGiamGia phieuGiamGia = new PhieuGiamGia();
        phieuGiamGia.setMaPhieu(request.getMaPhieu());
        phieuGiamGia.setTenPhieu(request.getTenPhieu());
        phieuGiamGia.setNgayBatDau(request.getNgayBatDau());
        phieuGiamGia.setGiaTriGiam(Float.valueOf(request.getGiaTriGiam()));
        phieuGiamGia.setKhachHang(KhachHang.builder().maKhachHang(request.getMaKhachHang()).tenKhachHang(request.getTenKhachHang()).build());
        return phieuGiamGiaRepo.save(phieuGiamGia);
    }

    public PhieuGiamGia update(String maPhieu, PhieuGiamGiaRequest request){
        PhieuGiamGia phieuGiamGia = phieuGiamGiaRepo.findById(maPhieu).get();
        phieuGiamGia.setTenPhieu(request.getTenPhieu());
        phieuGiamGia.setNgayBatDau(request.getNgayBatDau());
        phieuGiamGia.setGiaTriGiam(Float.valueOf(request.getGiaTriGiam()));
        phieuGiamGia.setKhachHang(KhachHang.builder().maKhachHang(request.getMaKhachHang()).tenKhachHang(request.getTenKhachHang()).build());
        return phieuGiamGiaRepo.save(phieuGiamGia);
    }

    public Stream<PhieuGiamGia> sort(){
        return phieuGiamGiaRepo.findAll().stream().sorted(Comparator.comparing(PhieuGiamGia::getGiaTriGiam, Comparator.reverseOrder()));
    }

    public double count(){
        return phieuGiamGiaRepo.findAll().stream().filter(o-> o.getKhachHang().getMaKhachHang()==3).count();
    }

    public List<PhieuGiamGia>  loc(){
        return phieuGiamGiaRepo.findAll().stream().filter(o->o.getGiaTriGiam()>=20 && o.getGiaTriGiam()<=100).collect(Collectors.toList());
    }
}
