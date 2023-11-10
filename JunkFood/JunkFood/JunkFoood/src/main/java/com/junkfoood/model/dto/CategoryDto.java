package com.junkfoood.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.junkfoood.model.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private Integer id;

    @NotBlank(message = "Name khong duoc de trong")
    private String name;

    private List<ProductEntity> products;
}
