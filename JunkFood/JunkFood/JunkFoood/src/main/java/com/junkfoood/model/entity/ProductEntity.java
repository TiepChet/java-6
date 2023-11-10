package com.junkfoood.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String image;

    private Double price;

    private Date createDate;

    private Integer available;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetailEntity> orderDetailList;
}
