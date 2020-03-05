package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    MessageSource messageSource;
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greetingWithName() {
        logger.debug("Hello from Logback {}", "123");
        return "index";
    }
}
