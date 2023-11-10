package com.demo.model;

import lombok.AllArgsConstructor;
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
@Table(name = "chitietsp")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsp", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idnsx", referencedColumnName = "id")
    private NSX nsx;

    @Column(name = "nambh")
    private int namBH;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "soluongton")
    private int soLuongTon;

    @Column(name = "gianhap")
    private float giaNhap;

    @Column(name = "giaban")
    private float giaBan;
}
