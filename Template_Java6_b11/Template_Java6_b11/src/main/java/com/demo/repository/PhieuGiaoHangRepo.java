package com.demo.repository;

import com.demo.model.PhieuGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {

    @Query(value = "select * from PhieuGiaoHang order by PhieuGiaoHang.PhiGiaoHang asc", nativeQuery = true)
     List<PhieuGiaoHang> sapXep();
}
