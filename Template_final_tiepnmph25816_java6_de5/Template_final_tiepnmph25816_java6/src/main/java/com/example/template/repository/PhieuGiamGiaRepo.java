package com.example.template.repository;

import com.example.template.dao.PhieuGiamGiaCustom;
import com.example.template.model.PhieuGiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuGiamGiaRepo extends JpaRepository<PhieuGiamGia, String> {

    @Query(value = "select  PhieuGiamGia.MaPhieu, PhieuGiamGia.TenPhieu, PhieuGiamGia.NgayBatDau, PhieuGiamGia.GiaTriGiam, KhachHang.MaKhachHang, KhachHang.TenKhachHang from PhieuGiamGia join KhachHang on KhachHang.MaKhachHang = PhieuGiamGia.NguoiSoHuu", nativeQuery = true)
    List<PhieuGiamGiaCustom> getAll();
}
