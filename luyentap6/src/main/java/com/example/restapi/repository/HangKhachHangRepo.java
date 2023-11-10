package com.example.restapi.repository;

import com.example.restapi.model.HangKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HangKhachHangRepo extends JpaRepository<HangKhachHang,Integer> {

    @Query("SELECT p FROM HangKhachHang p WHERE " + "p.tenHang LIKE CONCAT('%',:tenHang,'%')")
    List<HangKhachHang> search(String tenHang);
}
