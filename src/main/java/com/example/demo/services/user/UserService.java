package com.example.demo.services.user;

import java.util.List;

import com.example.demo.models.User;

public interface UserService {
    public List<User> getUsers();

    public void storeUser(User user);

    public User findById(Long id);

    public void deleteById(Long id);
}