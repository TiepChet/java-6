package com.junkfoood.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.junkfoood.model.entity.AccountEntity;
import com.junkfoood.model.entity.RoleEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class AuthorityDto {

    private Integer id;
    private RoleEntity role;

    @JsonProperty("account_auth")
    private AccountEntity accountAuth;

}
