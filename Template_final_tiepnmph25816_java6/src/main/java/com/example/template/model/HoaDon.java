package com.example.template.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hoadon")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahoadon")
    private Long maHoaDon;

    @Column(name = "nguoilap")
    private String nguoiLap;

    @Column(name = "ghichu")
    private String ghiChu;

    //Mã Phiếu Giao, Người Nhận, SĐT Người Nhận, Phí Giao Hàng, Người Lập, Hoá đơn ghi chú
}
