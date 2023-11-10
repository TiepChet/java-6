package com.demo.repository;

import com.demo.dao.PhieuGiaoHangCustom;
import com.demo.model.PhieuGiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, String> {

    @Query(value = "select PhieuGiaoHang.MaPhieuGiao, PhieuGiaoHang.NguoiNhan, PhieuGiaoHang.SdtNhan, PhieuGiaoHang.PhiGiaoHang, HoaDon.NguoiLap, HoaDon.GhiChu, HoaDon.MaHoaDon from PhieuGiaoHang join HoaDon on HoaDon.MaHoaDon = PhieuGiaoHang.HoaDonGiao", nativeQuery = true)
    Page<PhieuGiaoHangCustom> getAll(Pageable pageable);
}
