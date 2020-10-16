package com.example.demo.controller;

import com.example.demo.controller.request.CreateUserRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public void createTransaction(
            @RequestBody CreateUserRequest userRequest

    ) {
        User user = new User();
        user.setName(userRequest.getName());
        userService.saveUser(user);

    }


}
