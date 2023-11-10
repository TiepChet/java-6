package com.junkfoood.service;

import com.junkfoood.model.dto.CategoryDto;
import com.junkfoood.model.entity.CategoryEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Page<CategoryDto> getAllAndPage(int page, int page_size);

    List<CategoryDto> getAll();

    CategoryDto getOne(Integer id);

    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(Integer id, CategoryDto categoryDto);

    void delete(Integer id);

    CategoryEntity checkIdCategory(Integer id);
}
