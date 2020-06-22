package com.example.backendkyc.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SA_ROLE_FUNCTION")
public class RoleFunction {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int roleFunctionID;

    @Column(name = "ROLE_ID")
    private int roleID;

    @Column(name = "FUNCTION_ID")
    private int functionID;

    public int getRoleFunctionID() {
        return roleFunctionID;
    }

    public void setRoleFunctionID(int roleFunctionID) {
        this.roleFunctionID = roleFunctionID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getFunctionID() {
        return functionID;
    }

    public void setFunctionID(int functionID) {
        this.functionID = functionID;
    }
}
