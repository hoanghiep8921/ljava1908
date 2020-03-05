package com.example.admin_mvc.controller;

import com.example.admin_mvc.model.ProductModel;
import com.example.admin_mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/productdb")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String homeProduct(Model model){
        List<ProductModel> list = productRepository.findAll();
        //productRepository.delete();
        //productRepository.save()
        //productRepository.deleteById();
        model.addAttribute("listProduct",list);
        return "productHome";
    }
}
