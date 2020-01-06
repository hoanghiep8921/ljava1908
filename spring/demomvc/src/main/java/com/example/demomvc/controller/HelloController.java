package com.example.demomvc.controller;

import com.example.demomvc.model.Game;
import com.example.demomvc.model.GoodBye;
import com.example.demomvc.model.Hello;
import com.example.demomvc.model.MenuItem;
import com.example.demomvc.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    private List<Game> lstGame = new ArrayList<>();
    private List<MenuItem> lstMenu = new ArrayList<>();
    @PostConstruct
    public void mockData(){
        //mock data
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));
        lstMenu.add(new MenuItem("Steam","https://www.freeiconspng.com/uploads/flat-blue-home-icon-4.png"));

        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 1"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 2"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 3"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 4"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 5"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 6"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 7"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 8"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 9"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 10"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 11"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 12"));
    }

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
    public String home(Model model,
                       @RequestParam(value = "page",defaultValue = "0") int page,
                       @RequestParam(value = "filter",defaultValue = "0") int filter){

        List<Game> gameOfPage = new ArrayList<>();
        int index = page*Constant.PAGE_SIZE;
        int lengthGame = page*Constant.PAGE_SIZE + Constant.PAGE_SIZE
                > lstGame.size() ? lstGame.size() :
                page*Constant.PAGE_SIZE + Constant.PAGE_SIZE ;

        for(int i = index ; i < lengthGame ; i++ ){
            Game game = lstGame.get(i);
            if(filter == 1){
                if(game.getPriceNew() < 5000000)
                    gameOfPage.add(game);
            }else{
                gameOfPage.add(game);
            }

        }

        //transfer to view
        int totalPage = lstGame.size() % Constant.PAGE_SIZE != 0 ?
                (lstGame.size()/Constant.PAGE_SIZE + 1) :
                (lstGame.size()/Constant.PAGE_SIZE);

        model.addAttribute("listGame",gameOfPage);
        model.addAttribute("listMenu",lstMenu);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("currentPage",page);

        return "home";
    }


    @RequestMapping("/detail")
    public String detail(){
        return "detail";
    }
}
