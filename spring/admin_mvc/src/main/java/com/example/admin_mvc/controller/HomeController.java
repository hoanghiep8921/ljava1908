package com.example.admin_mvc.controller;

import com.example.admin_mvc.model.Product;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<Product> lstProduct = new ArrayList<>();

    @PostConstruct
    public void mockUp(){
        lstProduct.add(new Product("Product 1","Description product 1",100,3));

        lstProduct.add(new Product("Product 2","Description product 2",100,3));

        lstProduct.add(new Product("Product 3","Description product 3",100,3));
    }


    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("listProduct",lstProduct);
        model.addAttribute("message","");
        return "index";
    }

    @RequestMapping("/create-product")
    public String createGame(@RequestParam("name")String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") int price,
                             @RequestParam("star") int numberStar,
                             Model model){

        String message = "";
        if(name != null && description != null && price > 0 && numberStar > 0){
            message = "Thêm thành công";
            lstProduct.add(new Product(name,description,price,numberStar));
        }else{
            message = "Dữ liệu không hợp lệ";
        }

        model.addAttribute("message",message);
        model.addAttribute("listProduct",lstProduct);
        return "index";
    }


    @RequestMapping(value = "/create-product",
            method = RequestMethod.POST)
    @ResponseBody //không trả về trang web
    public void createNewProduct(@RequestBody Product product){
        lstProduct.add(product);
    }


}
