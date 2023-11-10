package com.demo.repository;

import com.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhachHangRepo extends JpaRepository<KhachHang,Long> {


    @Query("SELECT p FROM KhachHang p WHERE " + "p.tenKhachHang LIKE CONCAT('%',:tenKhachHang, '%')")
    List<KhachHang> search(String tenKhachHang);


    @Query(value = "select * from KhachHang order by TenKhachHang asc",nativeQuery = true)
    List<KhachHang> sapXep();
}
