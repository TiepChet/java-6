package com.demo.repository;

import com.demo.dao.ChiTietSanPhamCustom;
import com.demo.model.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSanPham, UUID> {
    @Query(value = "select ChiTietSP.Id, SanPham.ma, NSX.Ten, ChiTietSP.NamBH, ChiTietSP.MoTa, ChiTietSP.SoLuongTon, ChiTietSP.GiaNhap, ChiTietSP.GiaBan  from ChiTietSP join SanPham on ChiTietSP.IdSP = SanPham.Id join NSX on ChiTietSP.IdNsx = NSX.id", nativeQuery = true)
    List<ChiTietSanPhamCustom> getAll();
}
