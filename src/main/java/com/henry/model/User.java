package com.henry.model;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class User {

    @Id
    @SequenceGenerator(name = "USERS_id", sequenceName = "USERS_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "USERS_id")
    private Long id;

    private String name;
    private Integer age;

    public User(){}
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
