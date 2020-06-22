package com.example.backendkyc.reposiroty;

import com.example.backendkyc.model.RoleFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RoleFunctionRepository extends JpaRepository<RoleFunction,Integer> {
    @Modifying
    @Transactional
    @Query("delete from RoleFunction r where r.roleID = ?1")
    void deleteByRoleID(int roleId);
}
