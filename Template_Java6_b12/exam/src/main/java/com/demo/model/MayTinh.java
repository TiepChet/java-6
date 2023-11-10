package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "may_tinh")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MayTinh {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ma")
    private UUID ma;

    @Column(name = "ten")
    @NotBlank(message = "Không để trống")
    private String ten;

    @Column(name = "gia")
    @NotNull(message = "Không để trống")
    private float gia;

    @Column(name = "bo_nho")
    @NotBlank(message = "Không để trống")
    private String boNho;
}
