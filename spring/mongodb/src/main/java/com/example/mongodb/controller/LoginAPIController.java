package com.example.mongodb.controller;

import com.example.mongodb.dto.BaseResponse;
import com.example.mongodb.model.Users;
import com.example.mongodb.repository.UserRepository;
import com.example.mongodb.services.TokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoginAPIController {

    @Autowired
    TokenServices tokenServices;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponse login(@RequestParam("username")String username,
                              @RequestParam("password")String password){
        BaseResponse response = new BaseResponse();
        try{
            String enCodePassword = passwordEncoder.encode(password);
            Optional<Users> optionalUsers =
                    userRepository.findById(username);
            if(!optionalUsers.isPresent()){
                throw new Exception("username invalid");
            }
            Users users = optionalUsers.get();

            if(!passwordEncoder.matches(password, users.getPassword())){
                throw new Exception("Password invalid");
            }
            response.setCode("00");
            response.setData(tokenServices.generateJWT(users.getId()));
            response.setMessage("Login success");
        }catch (Exception e){
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/getInfoUser",method = RequestMethod.GET)
    public BaseResponse getInfo(@RequestHeader("Authen")String token){
        BaseResponse response = new BaseResponse();
        try{
            if(!tokenServices.validateToken(token)){
                throw new Exception("Token invalid");
            }
            response.setCode("00");
            response.setMessage("Laays thong tin thanhf coong");
            response.setData("User info");
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setCode("99");
        }
        return response;
    }


}
