package com.example.template.repository;

import com.example.template.dao.PhieuGiaoHangCustom;
import com.example.template.model.PhieuGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {

    @Query(value = "select PhieuGiaoHang.MaPhieuGiao, PhieuGiaoHang.NguoiNhan, PhieuGiaoHang.SdtNhan, PhieuGiaoHang.PhiGiaoHang, HoaDon.NguoiLap, HoaDon.GhiChu from PhieuGiaoHang join HoaDon on PhieuGiaoHang.HoaDonGiao = HoaDon.MaHoaDon", nativeQuery = true)
    List<PhieuGiaoHangCustom> getAll();
}
