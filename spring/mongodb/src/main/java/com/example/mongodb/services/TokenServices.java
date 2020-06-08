package com.example.mongodb.services;

import com.example.mongodb.model.Users;
import com.example.mongodb.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TokenServices {
    static final long EXPIRATIONTIME = 864_000_000;
    static final String SECRET = "123456zx";
    @Autowired
    UserRepository userRepository;

    public String generateJWT(String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() +
                        EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return JWT;
    }

    public String readJWT(String token) {
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return user;
        }
        return null;
    }

    public boolean validateToken(String token){
        try{
            String userId = readJWT(token);
            Optional<Users> optionalUsers = userRepository.findById(userId);
            if(!optionalUsers.isPresent()){
                throw new Exception("user not found");
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
