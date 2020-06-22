package com.example.backendkyc.reposiroty;

import com.example.backendkyc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findByRoleCodeAndStatus(String code, Integer status);
    Role findByRoleCode(String roleCode);
}
