//package com.junkfoood.rest.controller;
//
//import com.junkfoood.model.request.AuthRequest;
//import com.junkfoood.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = {"http://127.0.0.1:5501/"})
//@RestController
//@RequestMapping("/api/auth")
//public class AuthRestController {
//    @Autowired
//    private JwtUtil jwtUtil;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @GetMapping("/")
//    public String welcome() {
//        return "Welcome to javatechie !!";
//    }
//
//    @PostMapping("/login")
//    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//            );
//        } catch (Exception ex) {
//            throw new Exception("inavalid username/password");
//        }
//        return jwtUtil.generateToken(authRequest.getUsername());
//    }
//
//
//}
