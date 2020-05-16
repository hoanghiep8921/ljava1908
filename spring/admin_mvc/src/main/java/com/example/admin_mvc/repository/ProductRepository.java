package com.example.admin_mvc.repository;

import com.example.admin_mvc.model.ProductModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
    // select * from product where name = ?1
    List<ProductModel> findByName(String name);
    // select * from product where name like %?%
    //@Query("")
    List<ProductModel> findByNameContaining(String name, Pageable pageable);
}
