package com.example.template.repository;

import com.example.template.dao.TheThanhVienCustom;
import com.example.template.model.TheThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheThanhVienRepo extends JpaRepository<TheThanhVien, String> {

    @Query(value = "select TheThanhVien.MaThe, TheThanhVien.MauThe, TheThanhVien.LoaiThe, TheThanhVien.NgayPhatHanh, KhachHang.MaKhachHang, KhachHang.TenKhachHang from TheThanhVien join KhachHang on KhachHang.MaKhachHang = TheThanhVien.NguoiSoHuu", nativeQuery = true)
    List<TheThanhVienCustom> getAll();

}
