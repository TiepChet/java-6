//package com.junkfoood.service.impl;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.junkfoood.model.entity.AccountEntity;
//import com.junkfoood.model.entity.AuthorityEntity;
//import com.junkfoood.model.entity.OrderEntity;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Data
//public class UserDetailsImpl implements UserDetails {
//    private Integer id;
//    private String username;
//    private String password;
//    private String fullname;
//    private String email;
//    private String photo;
//    private Collection<? extends GrantedAuthority> authorities;
//
//
//    public UserDetailsImpl(Integer id, String username, String password, String fullname, String email, String photo, Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.fullname = fullname;
//        this.email = email;
//        this.photo = photo;
//        this.authorities = authorities;
//    }
//
//    public static UserDetailsImpl build(AccountEntity accountEntity) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        for (AuthorityEntity authority : accountEntity.getAuthorities()) {
//            authorities.add(new SimpleGrantedAuthority((authority.getRole().getId())));
//        }
//
//        System.out.println(authorities+"ghjkl");
//
//        return new UserDetailsImpl(
//                accountEntity.getId(),
//                accountEntity.getUsername(),
//                accountEntity.getPassword(),
//                accountEntity.getFullname(),
//                accountEntity.getEmail(),
//                accountEntity.getPhoto(),
//                authorities);
//
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
