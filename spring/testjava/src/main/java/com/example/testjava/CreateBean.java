package com.example.testjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBean {

    @Bean("bikini")
    public Outfit createBeanBikini(){
        return new Bikini();
    }

    @Bean("clothes")
    public Outfit createBeanClothes(){
        return new Clothes();
    }

}
