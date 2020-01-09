package com.example.admin_mvc.controller;

@Controller
public class HomeController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
