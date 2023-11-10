package com.example.demo.Buoi4.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chitietsp")
public class ChiTietSanPham {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "nambh")
    private Integer namBH;

    @Column(name = "soluongton")
    private Integer soLuongTon;

    @Column(name = "gianhap")
    private BigDecimal giaNhap;

    @Column(name = "giaban")
    private BigDecimal giaBan;

    @Column(name = "mota")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "idsp")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "idnsx")
    private NhaSanXuat nhaSanXuat;


}
