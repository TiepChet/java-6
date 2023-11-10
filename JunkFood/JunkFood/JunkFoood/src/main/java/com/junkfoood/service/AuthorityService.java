package com.junkfoood.service;

import com.junkfoood.model.dto.AuthorityDto;

import java.util.List;

public interface AuthorityService {
    List<AuthorityDto> getAll();

    AuthorityDto create(AuthorityDto authorityDto);

    void delete(Integer id);
}
