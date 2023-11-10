package com.example.template.repository;

import com.example.template.dao.PhieuGiaoHangCustom;
import com.example.template.model.PhieuGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {

    @Query(value = "select PhieuGiaoHang.MaPhieuGiao,  PhieuGiaoHang.NguoiNhan,  PhieuGiaoHang.SdtNhan, HoaDon.MaHoaDon, HoaDon.NguoiLap, DiaChi.MaDiaChi, DiaChi.TenDiaChi, DiaChi.MoTaChiTiet from PhieuGiaoHang join HoaDon on HoaDon.MaHoaDon = PhieuGiaoHang.HoaDonGiao join DiaChi on DiaChi.MaDiaChi = PhieuGiaoHang.DiaChiGiao",nativeQuery = true)
    List<PhieuGiaoHangCustom> getAll();
}
