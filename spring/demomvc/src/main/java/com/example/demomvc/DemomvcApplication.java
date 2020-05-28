package com.example.demomvc;

import com.example.demomvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemomvcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemomvcApplication.class, args);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        User u = new User();
//        u.setName("Haa");
//        u.setId("Hiepdh");
//        u.setPassword(passwordEncoder.encode("123456"));
//        userRepositove.save(u);
    }
}
