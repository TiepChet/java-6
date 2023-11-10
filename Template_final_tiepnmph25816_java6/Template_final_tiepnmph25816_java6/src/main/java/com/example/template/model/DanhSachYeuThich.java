package com.example.template.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DanhSachYeuThich")
public class DanhSachYeuThich {

    @Id
    @Column(name = "MaDanhSach")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID maDanhSach;

    @Column(name = "NgayTao")
    private String ngayTao;

    @Column(name = "NgayCapNhap")
    private String ngayCapNhap;

    @ManyToOne
    @JoinColumn(name = "NguoiSoHuu")
    private KhachHang khachHang;
}
