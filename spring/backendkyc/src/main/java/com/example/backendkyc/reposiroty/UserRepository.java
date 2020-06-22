package com.example.backendkyc.reposiroty;

import com.example.backendkyc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
        Optional<User> findByUserName(String name);
        List<User> findByStatus(Integer status);
}