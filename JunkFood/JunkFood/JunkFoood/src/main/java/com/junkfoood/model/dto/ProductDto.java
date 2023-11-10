package com.junkfoood.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.junkfoood.model.entity.CategoryEntity;
import com.junkfoood.model.entity.OrderDetailEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProductDto {

    private Integer id;

    @NotBlank(message = "Name không được để trống")
    private String name;
    private String image;

    @Min(value = 1, message = "Giá phải lớn hơn 1")
    private Double price;

    @JsonProperty("create_date")
    private Date createDate;

    private Integer available;

    private CategoryEntity category;

    @JsonProperty("order_detail_list")
    private List<OrderDetailEntity> orderDetailList;

}
