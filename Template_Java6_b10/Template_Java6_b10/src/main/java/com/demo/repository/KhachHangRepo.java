package com.demo.repository;

import com.demo.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {
//    @Query(value = "select sp.Ma, nsx.Ten,ctsp.NamBH,ctsp.MoTa, ctsp.SoLuongTon,ctsp.GiaNhap, ctsp.GiaBan \n" +
//            "from ChiTietSP ctsp \n" +
//            "join SanPham sp on sp.Id = ctsp.IdSP \n" +
//            "join NSX nsx on nsx.id = ctsp.IdNsx", nativeQuery = true)
//    List<ChiTietSPCusTom> getCusTomSanPham();
}
