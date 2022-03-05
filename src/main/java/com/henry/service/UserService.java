package com.henry.service;

import com.henry.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Iterable<User> findAll();
    public Optional<User> findById(long id);
    public void delete(long id);
    public User create(String name,Integer age);
    public User changeAge(Long id,Integer age);
    public List<User> findByAge(Integer age);
}
