package com.example.cache;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 5517244812959569947L;

    private Long id;
    private String firstName;
    private String lastName;

    public Employee() {
        super();
    }

    public Employee(Long id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}