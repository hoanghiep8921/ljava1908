package com.example.admin_mvc.api;

import com.example.admin_mvc.model.BaseResponse;
import com.example.admin_mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class ProductAPIController {

    @Autowired
    private ProductRepository productRepository;

    //Lấy tất cả product trong DB
    @RequestMapping(value = "/products",method = RequestMethod.GET)
    //@GetMapping("/products")
    public BaseResponse getAllProduct(){
        BaseResponse response = new BaseResponse();
        response.setCode("00");
        response.setMessage("Success");
        response.setData(productRepository.findAll());
        return response;
    }
}
