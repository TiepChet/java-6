package com.example.template.repository;

import com.example.template.dao.KhachHangCustom;
import com.example.template.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {

    @Query(value = "select KhachHang.MaKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai, KhachHang.GioiTinh, HangKhachHang.MaHang, HangKhachHang.TenHang, HangKhachHang.MoTa from KhachHang join HangKhachHang on HangKhachHang.MaHang = KhachHang.HangKhachHang", nativeQuery = true)
    List<KhachHangCustom> getAll();
}
