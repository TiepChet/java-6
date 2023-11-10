package com.junkfoood.service.impl;

import com.junkfoood.model.dto.AuthorityDto;
import com.junkfoood.model.entity.AuthorityEntity;
import com.junkfoood.reponsitory.AuthorityReponsitory;
import com.junkfoood.service.AuthorityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityReponsitory authorityReponsitory;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<AuthorityDto> getAll(){
        List<AuthorityEntity> authorityEntities = authorityReponsitory.findAll();
        return authorityEntities.stream().map(authorityEntity ->
                modelMapper.map(authorityEntity,AuthorityDto.class)).collect(Collectors.toList());
    }

    @Override
    public AuthorityDto create(AuthorityDto authorityDto){
        AuthorityEntity authorityEntity = modelMapper.map(authorityDto,AuthorityEntity.class);
        return  modelMapper.map(authorityReponsitory.save(authorityEntity),AuthorityDto.class);
    }

    @Override
    public void delete(Integer id){
        authorityReponsitory.deleteById(id);
    }


}
