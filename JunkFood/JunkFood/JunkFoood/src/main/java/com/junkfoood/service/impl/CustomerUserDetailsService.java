//package com.junkfoood.service.impl;
//
//import com.junkfoood.model.entity.AccountEntity;
//import com.junkfoood.reponsitory.AccountReponsitory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.stream.Collectors;
//
//@Service
//public class CustomerUserDetailsService  implements UserDetailsService {
//
//    @Autowired
//    private AccountReponsitory accountReponsitory;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Kiểm tra xem user có tồn tại trong database không?
//        AccountEntity user = accountReponsitory.findByUsername(username);
//
////        String[] roles = user.getAuthorities().stream()
////                .map(er -> er.getRole().getId())
////                .collect(Collectors.toList()).toArray(new String[0]);// đổi sang mảng
//
//        return UserDetailsImpl.build(user);
//
////        return new org.springframework.security.core.userdetails.User
////                (user.getUsername(),user.getPassword(),new ArrayList<>());
//    }
//}
