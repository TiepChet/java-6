package com.junkfoood.service;

import com.junkfoood.model.dto.ProductDto;
import com.junkfoood.model.entity.ProductEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<ProductDto> getAllAndPage(int page, int page_size);

    List<ProductDto> getAll();

    ProductDto getOne(Integer id);

    List<ProductDto> getProductCateId(Integer id);

    ProductDto create(ProductDto productDto);

    ProductDto update(Integer id, ProductDto productDto);

    void delete(Integer id);

    ProductEntity checkIdProduct(Integer id);
}
