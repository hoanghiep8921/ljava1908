package com.example.demomvc.controller;

import com.example.demomvc.model.Game;
import com.example.demomvc.model.GoodBye;
import com.example.demomvc.model.Hello;
import com.example.demomvc.model.MenuItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    public String home(Model model){
        //mock data
        List<Game> lstGame = new ArrayList<>();
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 1"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 2"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 3"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 4"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 5"));

        List<MenuItem> lstMenu = new ArrayList<>();
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));



        //transfer to view
        model.addAttribute("listGame",lstGame);
        model.addAttribute("listMenu",lstMenu);

        return "home";
    }


    @RequestMapping("/detail")
    public String detail(){
        return "detail";
    }
}
