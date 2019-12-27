package com.example.testjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class TestjavaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestjavaApplication.class, args);
    }

    @Autowired
    @Qualifier("clothes")
    private Outfit outfit;

    @Override
    public void run(String... args) throws Exception {
        //Outfit outfit = new Bikini();
        Girl girl = new Girl(outfit);
        girl.getOutfit().wear();
    }
}
