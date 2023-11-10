package com.demo.entity;

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

@Entity
@Table(name = "khachhang")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makhachhang")
    private long maKhachHang;

    @Column(name = "tenkhachhang")
    private String tenKhachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hangkhachhang",referencedColumnName = "maHang")
    private HangKhachHang hangKhachHang;
}
