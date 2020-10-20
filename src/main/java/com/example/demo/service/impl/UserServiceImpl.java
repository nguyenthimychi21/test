package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        //return userRepository.findById(id);
        Optional<User> studentResponse =  userRepository.findById(id);
        User student = studentResponse.get();
        return student;
    }


    @Override
    public List<User> getAllDomain() {
        List<User> userArrayList = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        users.forEach(item -> userArrayList.add(item));
        //return (List<User>)userRepository.findAll();
        return userArrayList;
    }


}
