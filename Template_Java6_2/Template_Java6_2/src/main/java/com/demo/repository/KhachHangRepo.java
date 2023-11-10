package com.demo.repository;

import com.demo.dao.KhachHangCustom;
import com.demo.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {

    @Query(value = "select KhachHang.MaKhachHang, KhachHang.TenKhachHang, KhachHang.SoDienThoai, KhachHang.GioiTinh, HangKhachHang.MaHang,  HangKhachHang.TenHang from KhachHang join HangKhachHang on HangKhachHang.MaHang = KhachHang.HangKhachHang", nativeQuery = true)
    Page<KhachHangCustom> getAll(Pageable pageable);
}
