package com.junkfoood.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;

    @JsonIgnore
    @OneToMany(mappedBy = "account", orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<OrderEntity> orders;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "accountAuth",cascade = CascadeType.ALL)
    private List<AuthorityEntity> authorities = new ArrayList<>();
//    private Collection<AuthorityEntity> authorities = new LinkedHashSet<AuthorityEntity>();
//    private List<Authority> authorities;
}
