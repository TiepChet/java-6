package com.example.template.repository;

import com.example.template.dao.DanhSachYeuThichCustom;
import com.example.template.model.DanhSachYeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DanhSachYeuThichRepo extends JpaRepository<DanhSachYeuThich, UUID> {

    @Query(value = "select DanhSachYeuThich.MaDanhSach, DanhSachYeuThich.NgayTao, DanhSachYeuThich.NgayCapNhap, KhachHang.MaKhachHang, KhachHang.TenKhachHang from DanhSachYeuThich join KhachHang on KhachHang.MaKhachHang=DanhSachYeuThich.NguoiSoHuu",nativeQuery = true)
    List<DanhSachYeuThichCustom> getAll();
}
