package com.example.mongodb.controller;

import com.example.mongodb.dto.BaseResponse;
import com.example.mongodb.dto.ProductCart;
import com.example.mongodb.dto.UpdateCartRequest;
import com.example.mongodb.model.Order;
import com.example.mongodb.model.Product;
import com.example.mongodb.model.ProductModel;
import com.example.mongodb.repository.OrderRepository;
import com.example.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderAPIController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    //lấy sản phẩm hiện tại trong giỏ hàng của user
    @RequestMapping("/products/{id}")
    public BaseResponse getListProductInCart(
            @PathVariable("id")String id){
        BaseResponse response = new BaseResponse();
        Optional<Order> optionalOrder = orderRepository.findByBuyerAndStatus(id,1);
        //1,New account
        //2,Just ordered
        if(!optionalOrder.isPresent()){
            Order order = new Order();
            order.setBuyer(id);
            //order.setId("MH235");
            order.setStatus(1);
            orderRepository.save(order);
            response.setCode("00");
            response.setMessage("Create new cart for user " + id);
            response.setData(order);
        }else{
            Order exits = optionalOrder.get();
            response.setCode("00");
            response.setMessage("Create new cart for user " + id);
            response.setData(exits);
        }
        return response;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public BaseResponse updateCart(
            @PathVariable("id") String id,
            @RequestBody UpdateCartRequest updateCartRequest){
        BaseResponse response = new BaseResponse();
        Optional<Order> optOrder = orderRepository.findById(id);
        if(!optOrder.isPresent()){
            response.setData(null);
            response.setMessage("Data not found");
            response.setCode("99");
            return response;
        }
        Order exitsOrder = optOrder.get();
        if(exitsOrder.getStatus() != 1){
            response.setData(null);
            response.setMessage("Cart invalid");
            response.setCode("98");
            return response;
        }
        //checkname
        List<ProductCart> lstProduct =
                updateCartRequest.getLstProductCart();

        List<ProductModel> productInCart = exitsOrder.getListProduct();
        for(ProductCart p : lstProduct){
            //add product
            if(p.getType() == 1){
                if (productInCart == null) {
                    productInCart = new ArrayList<>();
                    ProductModel productModel = new ProductModel();
                    productModel.setNumber(p.getNumber());
                    productModel.setId(p.getId());

                    //lấy thông tin sản phẩm trong DB
                    Product exitsProduct = productRepository.findById(p.getId()).get();
                    productModel.setPrice(exitsProduct.getPrice());
                    productModel.setName(exitsProduct.getName());
                    productModel.setImage(exitsProduct.getImage());

                    productInCart.add(productModel);
                    response.setCode("00");
                    response.setMessage("Thêm sản phẩm vào giỏ thành công");
                }else{
                    for(ProductModel pm : productInCart){
                        //p.getNumber là số sản phẩm muốn thêm
                        //check số sản phẩm hiện tại trong DB phải lớn hơn number
                        if(p.getId().equals(pm.getId()) && p.getNumber() > 0){
                            pm.setNumber(pm.getNumber() + p.getNumber());
                            response.setCode("00");
                            response.setMessage("Đã tăng số lượng thành công");
                        }else{
                            //Nếu không có trong list product của cart thì thêm mới
                            //product vào trong cart
                            ProductModel productModel = new ProductModel();
                            productModel.setNumber(pm.getNumber());
                            productModel.setId(pm.getId());
                            //lấy thông tin sản phẩm trong DB
                            Product exitsProduct = productRepository.findById(pm.getId()).get();
                            productModel.setPrice(exitsProduct.getPrice());
                            productModel.setImage(exitsProduct.getImage());

                            productInCart.add(pm);
                            response.setCode("00");
                            response.setMessage("Thêm sản phẩm vào giỏ thành công");
                        }
                    }
                }

            }
            //delete
            if(p.getType() == 2){
                for(ProductModel pm : productInCart){
                    //p.getNumber là số sản phẩm muốn thêm
                    //check số sản phẩm hiện tại trong DB phải lớn hơn number
                    if(p.getId().equals(pm.getId()) &&
                            p.getNumber() > 0 &&
                            p.getNumber() <= pm.getNumber() ){
                        pm.setNumber(pm.getNumber() - p.getNumber());
                        //nếu giảm xuống == 0 thì xóa luôn sản phẩm khỏi list
                        response.setMessage("Đã giảm số lượng sản phẩm");
                        if(pm.getNumber() == 0){
                            productInCart.remove(pm);
                            response.setMessage("Đã xóa sản phẩm ");
                        }
                        response.setCode("00");
                    }else{
                        response.setCode("99");
                        response.setMessage("Data invalid");
                    }
                }
            }
        }
        exitsOrder.setListProduct(productInCart);
        response.setCode("00");
        response.setMessage("Update giỏ hàng thành công");
        response.setData(orderRepository.save(exitsOrder));
        return response;
    }

    @RequestMapping(value = "/payment/{id}",
            method = RequestMethod.POST)
    public BaseResponse paymentOrder(
            @PathVariable("id") String id
    ){
        BaseResponse response = new BaseResponse();
        Optional<Order> optOrder = orderRepository.findById(id);
        if(!optOrder.isPresent()){
            response.setCode("99");
            response.setMessage("Data not found");
            return response;
        }
        Order exOrder = optOrder.get();
        exOrder.setStatus(2);
        exOrder.setCreatedAt(new Date());
        response.setMessage("Thanh toán thành công");
        response.setCode("00");
        return response;
    }
}
