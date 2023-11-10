package com.junkfoood.service.impl;

import com.junkfoood.contants.StatusContants;
import com.junkfoood.exception.NotFoundException;
import com.junkfoood.model.dto.ProductDto;
import com.junkfoood.model.entity.ProductEntity;
import com.junkfoood.reponsitory.ProductReponsitory;
import com.junkfoood.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductReponsitory productReponsitory;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<ProductDto> getAllAndPage(int page, int page_size){
        Page<ProductEntity> productEntities = productReponsitory.findByAvailableEquals(
                StatusContants.ACTIVE.getStatus(), PageRequest.of(page,page_size));
        return productEntities.map(productEntity -> modelMapper.map(productEntity,ProductDto.class));
    }

    @Override
    public List<ProductDto> getAll(){
        List<ProductEntity> productEntities = productReponsitory.findAll();
        return productEntities.stream().map(productEntity -> modelMapper.map(productEntity,ProductDto.class)).collect(Collectors.toList());
    }


    @Override
    public ProductDto getOne(Integer id){
        ProductEntity productEntity = productReponsitory.findById(id).get();
        return modelMapper.map(productEntity,ProductDto.class);
    }

    @Override
    public List<ProductDto> getProductCateId(Integer id){
        List<ProductEntity> productEntities = productReponsitory.findByCategoryId(id);
        return productEntities.stream().map(productEntity -> modelMapper.map(productEntity,ProductDto.class)).collect(Collectors.toList());
    }


    @Override
    public ProductDto create(ProductDto productDto){
        ProductEntity productEntity = modelMapper.map(productDto,ProductEntity.class);

        productEntity.setAvailable(1);
        productEntity.setCreateDate(new Date());

        return modelMapper.map(productReponsitory.save(productEntity),ProductDto.class);
    }

    @Override
    public ProductDto update(Integer id, ProductDto productDto){
        ProductEntity productFindId = checkIdProduct(id);

        ProductEntity productOld = productFindId;
        productFindId = modelMapper.map(productDto,ProductEntity.class);

        productFindId.setCreateDate(productOld.getCreateDate());
        productFindId.setAvailable(productOld.getAvailable());

        return modelMapper.map(productReponsitory.save(productFindId),ProductDto.class);
    }

    @Override
    public void delete(Integer id){
        checkIdProduct(id);
        productReponsitory.deleteById(id);
    }

    @Override
    public ProductEntity checkIdProduct(Integer id){
        Optional<ProductEntity> productEntity = productReponsitory.findById(id);
        if(productEntity.isPresent()){
            return productEntity.get();
        }
        throw new NotFoundException("Id not found");
    }

}
