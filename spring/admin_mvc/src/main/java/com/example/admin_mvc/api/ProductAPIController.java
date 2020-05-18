package com.example.admin_mvc.api;

import com.example.admin_mvc.dto.BaseResponse;
import com.example.admin_mvc.dto.ProductRequest;
import com.example.admin_mvc.model.ProductModel;
import com.example.admin_mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
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

    @RequestMapping("/product/{id}")
    public BaseResponse getProduct(@PathVariable("id") int index){
        BaseResponse response = new BaseResponse();
        Optional<ProductModel> optProduct = productRepository.findById(index);
        if(optProduct.isPresent()){
            response.setCode("00");
            response.setMessage("Success");
            response.setData(optProduct.get());
        }else{
            response.setCode("99");
            response.setMessage("Not found");
            response.setData(null);
        }
        return response;
    }

    @RequestMapping(value = "/product",method = RequestMethod.POST)
    public BaseResponse createProduct(@RequestBody ProductRequest productRequest){
        BaseResponse response = new BaseResponse();
        if(productRequest.getName().isEmpty() ||
                productRequest.getPrice().isEmpty() ||
                Float.parseFloat(productRequest.getPrice()) <= 0){
            response.setCode("98");
            response.setMessage("Data invalid");
            response.setData(null);
            return response;
        }
        ProductModel newProduct = new ProductModel();
        newProduct.setName(productRequest.getName());
        newProduct.setPrice(Float.parseFloat(productRequest.getPrice()));
        newProduct.setCreatedDate(new Date());
        response.setCode("00");
        response.setMessage("Create new Product success");
        response.setData(productRepository.save(newProduct));
        return response;
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.PUT)
    public BaseResponse updateProduct(@PathVariable("id") int id,
                                      @RequestBody ProductRequest productRequest){
        BaseResponse response = new BaseResponse();
        Optional<ProductModel> optProduct = productRepository.findById(id);
        if(optProduct.isPresent()){
            ProductModel exitsProduct = optProduct.get();
            if(!productRequest.getName().isEmpty()){
                exitsProduct.setName(productRequest.getName());
            }
            if(!productRequest.getPrice().isEmpty() &&
                    Float.parseFloat(productRequest.getPrice()) > 0){
                exitsProduct.setPrice(Float.parseFloat(productRequest.getPrice()));
            }

            response.setCode("00");
            response.setMessage("Update Product success");
            response.setData(productRepository.save(exitsProduct));
        }else{
            response.setCode("99");
            response.setMessage("Data Not found");
            response.setData(null);
        }
        return response;

    }

    @DeleteMapping("/product/{id}")
    public BaseResponse deleteProduct(@PathVariable("id")int id){
        BaseResponse response = new BaseResponse();
        try{
            Optional<ProductModel> optProduct = productRepository.findById(id);
            //throw new Exception("DB die");
            if(optProduct.isPresent()){
                productRepository.deleteById(id);
                response.setCode("00");
                response.setMessage("Delete product success");
                response.setData(id);
            }else{
                response.setCode("99");
                response.setMessage("Data not found");
                response.setData(id);
            }
        }catch (Exception e){
            response.setCode("90");
            response.setMessage("System erorr : " + e.getMessage());
            response.setData(id);
        }
        return response;
    }

    @RequestMapping(value = "/product/search",method = RequestMethod.GET)
    public BaseResponse Product(@RequestParam(value = "name",required = false) String name,
                                @RequestParam("page")int page,
                                @RequestParam("perPage") int perPage){
        BaseResponse response = new BaseResponse();
        try{
            Pageable pageable = PageRequest.of(page, perPage,
                    Sort.by(Sort.Direction.DESC,"id"));
            //PageRequest pageable = PageRequest.of(page,perPage);
            List<ProductModel> lstProduct =
                    productRepository.findByNameContaining(name,pageable);

            if(!lstProduct.isEmpty()){
                response.setCode("00");
                response.setMessage("List product search by key : " + name);
                response.setData(lstProduct);
            }else{
                response.setCode("99");
                response.setMessage("Data not found");
                response.setData(null);
            }
        }catch (Exception e){
            response.setCode("90");
            response.setMessage("System erorr : " + e.getMessage());
            response.setData(null);
        }
        return response;
    }

}
