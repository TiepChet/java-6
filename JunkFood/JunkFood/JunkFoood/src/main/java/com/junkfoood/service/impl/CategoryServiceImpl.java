package com.junkfoood.service.impl;

import com.junkfoood.exception.NotFoundException;
import com.junkfoood.model.dto.CategoryDto;
import com.junkfoood.model.entity.CategoryEntity;
import com.junkfoood.reponsitory.CategoryReponsitory;
import com.junkfoood.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryReponsitory categoryReponsitory;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public Page<CategoryDto> getAllAndPage(int page, int page_size){
        Page<CategoryEntity> categoryEntities = categoryReponsitory.findAll(PageRequest.of(page,page_size));
        return categoryEntities.map(categoryEntity -> modelMapper.map(categoryEntity,CategoryDto.class));
    }

    @Override
    public List<CategoryDto> getAll(){
        List<CategoryEntity> categoryDtoList = categoryReponsitory.findAll();
        return categoryDtoList.stream().map(categoryDto -> modelMapper.map(categoryDtoList,CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getOne(Integer id){
        CategoryEntity categoryEntity = categoryReponsitory.findById(id).get();
        return modelMapper.map(categoryEntity,CategoryDto.class);
    }


    @Override
    public CategoryDto create(CategoryDto categoryDto){
        CategoryEntity categoryEntity = modelMapper.map(categoryDto,CategoryEntity.class);
        return modelMapper.map(categoryReponsitory.save(categoryEntity),CategoryDto.class);
    }

    @Override
    public CategoryDto update(Integer id, CategoryDto categoryDto){
        CategoryEntity categoryEntity = modelMapper.map(categoryDto,CategoryEntity.class);
        return modelMapper.map(categoryReponsitory.save(categoryEntity),CategoryDto.class);
    }

    @Override
    public void delete(Integer id){
        checkIdCategory(id);
        categoryReponsitory.deleteById(id);
    }

    @Override
    public CategoryEntity checkIdCategory(Integer id){
        Optional<CategoryEntity> categoryEntity = categoryReponsitory.findById(id);
        if(categoryEntity.isPresent()){
            return categoryEntity.get();
        }
        throw new NotFoundException("Id not found");
    }



}
