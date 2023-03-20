package com.example.demo.services.user.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.user.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public void storeUser(User user)
    {
        userRepository.save(user);
    }

    public User findById(Long id)
    {
        return userRepository.findById(id).get();
    }

    public void deleteById(Long id)
    {
        userRepository.deleteById(id);
    }
}
