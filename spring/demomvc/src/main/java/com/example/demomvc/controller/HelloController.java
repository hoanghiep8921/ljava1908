package com.example.demomvc.controller;

import com.example.demomvc.model.GoodBye;
import com.example.demomvc.model.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model,
                        @RequestParam("name") String name,
                        @RequestParam("number1") int number1,
                        @RequestParam("number2") int number2){
        Hello hello = new Hello();

        model.addAttribute("hello",hello.getHello());
        model.addAttribute("test","Test DATA");
        model.addAttribute("user",name);
        model.addAttribute("result",number1+number2);
        return "hello";
    }

    @RequestMapping("/sum")
    @ResponseBody
    public int sumNumber(@RequestParam("number1") int number1,
                         @RequestParam("number2") int number2){
        return number1+number2;
    }

    @RequestMapping("/bye")
    public String goodBye(Model model){
        GoodBye goodBye = new GoodBye();
        model.addAttribute("goodBye",goodBye.getGoodBye());
        return "bye";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }


    @RequestMapping("/detail")
    public String detail(){
        return "detail";
    }
}
