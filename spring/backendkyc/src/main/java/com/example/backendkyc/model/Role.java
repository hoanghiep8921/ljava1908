package com.example.backendkyc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SA_ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer roleID;

    @Column(name = "ROLE_CODE")
    private String roleCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private Integer status;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "SA_ROLE_FUNCTION",
            joinColumns = {
                    @JoinColumn(name = "ROLE_ID")},
            inverseJoinColumns = {
                    @JoinColumn(name = "FUNCTION_ID")})
    private Set<Function> functions = new HashSet<>();

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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

    public Set<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(Set<Function> functions) {
        this.functions = functions;
    }

}
