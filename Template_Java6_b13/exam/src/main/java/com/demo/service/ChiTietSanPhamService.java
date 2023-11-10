package com.demo.service;

import com.demo.dao.ChiTietSanPhamCustom;
import com.demo.model.ChiTietSanPham;
import com.demo.repository.ChiTietSanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSanPhamService {

    @Autowired
    ChiTietSanPhamRepo chiTietSanPhamRepo;

    public List<ChiTietSanPhamCustom> getAll() {
        return chiTietSanPhamRepo.getAll();
    }

    public ChiTietSanPham getOne(UUID id){
        Optional<ChiTietSanPham> getOne = chiTietSanPhamRepo.findById(id);
        return getOne.isPresent() ? getOne.get() : null;
    }
}
