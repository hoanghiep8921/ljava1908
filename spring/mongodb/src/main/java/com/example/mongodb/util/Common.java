package com.example.mongodb.util;

import com.example.mongodb.model.Users;
import com.example.mongodb.repository.UserRepository;
import com.example.mongodb.services.TokenServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Common {
    @Autowired
    static TokenServices tokenServices;

}
