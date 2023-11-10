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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "phieugiaohang")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhieuGiaoHang {

    //Mã Phiếu Giao, Người Nhận, SĐT Người Nhận, Phí Giao Hàng, Người Lập, Hoá đơn ghi chú)  sử dụng method GET
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "maphieugiao")
    private UUID maPhieuGiao;

    @Column(name = "nguoinhan")
    @NotBlank(message = "Không để trống")
    private String nguoiNhan;

    @Column(name = "sdtnhan")
    @NotBlank(message = "Không để trống")
    private String soDienThoai;

    @Column(name = "phigiaohang")
    @NotNull(message = "Không để trống")
    private float phiGiaoHang;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "hoadongiao",referencedColumnName = "maHoaDon")
    private HoaDon hoaDon;

}
