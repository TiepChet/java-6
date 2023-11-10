package com.example.template.service;

import com.example.template.dao.DanhSachYeuThichCustom;
import com.example.template.dao.DanhSachYeuThichRequest;
import com.example.template.model.DanhSachYeuThich;
import com.example.template.model.KhachHang;
import com.example.template.repository.DanhSachYeuThichRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DanhSachYeuThichService {

    @Autowired
    DanhSachYeuThichRepo danhSachYeuThichRepo;

    public List<DanhSachYeuThichCustom> getAll() {
        return danhSachYeuThichRepo.getAll();
    }

    public Page<DanhSachYeuThich> findAll(Pageable pageable) {
        return danhSachYeuThichRepo.findAll(pageable);
    }

    public DanhSachYeuThich getOne(UUID maDanhSach) {
        return danhSachYeuThichRepo.findById(maDanhSach).get();
    }

    public boolean delete(UUID maDanhSach) {
        danhSachYeuThichRepo.deleteById(maDanhSach);
        return true;
    }

    public DanhSachYeuThich add(DanhSachYeuThichRequest request) {
        DanhSachYeuThich danhSachYeuThich = new DanhSachYeuThich();
        danhSachYeuThich.setKhachHang(KhachHang.builder().maKhachHang(request.getMaKhachHang()).tenKhachHang(request.getTenKhachHang()).build());
        danhSachYeuThich.setNgayTao(request.getNgayTao());
        danhSachYeuThich.setNgayCapNhap(request.getNgayCapNhap());
        return danhSachYeuThichRepo.save(danhSachYeuThich);
    }


    public DanhSachYeuThich update(UUID maDanhSach,DanhSachYeuThichRequest request) {
        DanhSachYeuThich danhSachYeuThich = danhSachYeuThichRepo.findById(maDanhSach).get();
        danhSachYeuThich.setKhachHang(KhachHang.builder().maKhachHang(request.getMaKhachHang()).tenKhachHang(request.getTenKhachHang()).build());
        danhSachYeuThich.setNgayTao(request.getNgayTao());
        danhSachYeuThich.setNgayCapNhap(request.getNgayCapNhap());
        return danhSachYeuThichRepo.save(danhSachYeuThich);
    }
}
