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
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PhieuGiaoHang")
public class PhieuGiaoHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MaPhieuGiao")
    private UUID maPhieuGiao;

    @Column(name = "NguoiNhan")
    private String nguoiNhan;

    @Column(name = "SdtNhan")
    private String sdtNhan;

    @Column(name = "PhiGiaoHang")
    private float phiGiaoHang;

    @ManyToOne
    @JoinColumn(name = "HoaDonGiao")
    private HoaDon hoaDon;

}
