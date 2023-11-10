//package com.junkfoood.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JwtUtil {
//    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
//    private  String secret = "iloveyoujava";
//
//    //Trích xuất tên người dùng
//    public String extractUsername(String token){
//        return extractClaim(token,Claims::getSubject);
//    }
//
//    // trích xuất hết hạn
//    public Date extractExpiration(String token){
//        return extractClaim(token,Claims::getExpiration);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims,T> claimsResolve){
//        final Claims claims = extractAllClaim(token);
//        return claimsResolve.apply(claims);
//    }
//
//    private Claims extractAllClaim(String token){
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    // token hết hạn không
//    private Boolean isTokenExpired(String token){
//        return extractExpiration(token).before(new Date());
//    }
//
//    // Tạo chuỗi json web token từ id của user.
//    public String generateToken(String username){
//        Map<String ,Object> claims = new HashMap<>();
//        return createToken(claims,username);
//    }
//
//    // Tạo chuỗi json web token từ id của user.
//    private String createToken(Map<String, Object> claims, String subject){
//
//        return Jwts.builder().setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS256,secret).compact();
//    }
//
//    // xác thực token
//    public Boolean validateToken(String token, UserDetails userDetails){
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//}
