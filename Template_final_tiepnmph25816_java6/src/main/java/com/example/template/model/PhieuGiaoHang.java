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

@Entity
@Table(name = "phieugiaohang")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhieuGiaoHang {

    //Mã Phiếu Giao, Người Nhận, SĐT Người Nhận, Phí Giao Hàng, Người Lập, Hoá đơn ghi chú
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "maphieugiao")
    private UUID maPhieuGiao;

    @Column(name = "nguoinhan")
    private String nguoiNhan;

    @Column(name = "sdtnhan")
    private String sdtNhan;

    @Column(name = "phigiaohang")
    private BigDecimal phiGiaoHang;

    @ManyToOne
    @JoinColumn(name = "hoadongiao")
    private HoaDon hoaDon;

}
