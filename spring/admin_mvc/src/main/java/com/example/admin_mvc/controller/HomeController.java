package com.example.admin_mvc.controller;

import com.example.admin_mvc.dto.BaseResponse;
import com.example.admin_mvc.model.Product;
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
        lstProduct.add(new Product("Product 1","Description product 1",100,3,1));

        lstProduct.add(new Product("Product 2","Description product 2",100,3,2));

        lstProduct.add(new Product("Product 3","Description product 3",100,3,3));
    }

    @RequestMapping(value = "/test-api",method = RequestMethod.GET)
    @ResponseBody //không trả về trang web
    public String testAPI(){
        return "Hello API";
    }

    //lấy tất cả danh sách sản phẩm
    @RequestMapping(value = "/api/products",method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getAllProduct(@RequestParam("fail") int i){
        BaseResponse response = new BaseResponse();
        if(i == 1){
            response.setData(null);
            response.setMessage("System errors");
            response.setCode("99");
        }else{
            response.setCode("00");
            response.setMessage("Get all products successfully");
            response.setData(lstProduct);
        }
        return response;
    }

    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam(value = "isSuccess",required = false) Boolean isSuccess){
        isSuccess = false;
        model.addAttribute("listProduct",lstProduct);
        if(isSuccess != null){
            model.addAttribute("message",isSuccess ? "Thành công" : "Thất bại");
        }
        model.addAttribute("message",isSuccess ? "Thành công" : "Thất bại");
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
            lstProduct.add(new Product(name,description,price,numberStar,lstProduct.size()+1));
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


    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Product exitsProduct = null;
        String message = "";
        for(Product p : lstProduct){
            if(p.getId() == id){
                exitsProduct = p;
            }
        }
        if(exitsProduct == null){
            message = " Không tìm thấy sản phẩm";
        }else{
            message = "Đã xóa sản phẩm thành công";
            lstProduct.remove(exitsProduct);
        }
        return "redirect:/index";
    }


    @RequestMapping("/edit/{productId}/detail")
    public String edit(Model model,@PathVariable("productId") int productId){
        Product exitsProduct = null;
        for(Product p : lstProduct){
            if(p.getId() == productId){
                exitsProduct = p;
            }
        }
        model.addAttribute("product",exitsProduct);
        return "detail";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public int editProduct(@RequestParam("id") int id,
                           @RequestBody Product product){
        Product exitsProduct = null;
        for(Product p : lstProduct){
            if(p.getId() == id){
                exitsProduct = p;
            }
        }

        if(product.getDescription() == null ||
                product.getDescription().isEmpty())
        {
            return 4;
        }
        exitsProduct.setName(product.getName());
        exitsProduct.setDescription(product.getDescription());
        exitsProduct.setPrice(product.getPrice());
        exitsProduct.setStar(product.getStar());
        return 0;
    }




}
