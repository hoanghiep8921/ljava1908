package com.example.backendkyc.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "SA_FUNCTION")
public class Function implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "functionID")
    private Integer functionID;

    @Column(name = "function_code")
    private String functionCode;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "functions")
//    private Set<Role> lstRoles;

    public Integer getFunctionID() {
        return functionID;
    }

    public void setFunctionID(Integer functionID) {
        this.functionID = functionID;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
