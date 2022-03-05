package com.henry.service.impl;

import com.henry.model.User;
import com.henry.repository.UserRepository;
import com.henry.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User create(String name, Integer age) {
        return userRepository.save(new User(name, age));
    }

    @Override
    public User changeAge(Long id, Integer age) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setAge(age);
            return userRepository.save(user);
        }

        throw new IllegalArgumentException("No User with id " + id + " exists");
    }

    @Override
    public List<User> findByAge(Integer age) {
        return userRepository.findByAge(age);
    }
}
