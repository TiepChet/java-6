package com.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "phieugiaohang")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhieuGiaoHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "maphieugiao")
    private String maPhieuGiao;

    @Column(name = "nguoinhan")
    private String nguoiNhan;

    @Column(name = "sdtgiao")
    private String soDienThoai;

    @Column(name = "phigiaohang")
    private float phiGiaoHang;

    @ManyToOne
    @JoinColumn(name = "hoadongiao",referencedColumnName = "maHoaDon")
    private HoaDon hoaDon;

}
