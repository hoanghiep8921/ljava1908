package com.example.admin_mvc.repository;

import com.example.admin_mvc.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
    
}
