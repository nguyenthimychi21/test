package com.example.demo.controller;

import com.example.demo.controller.request.CreateUserRequest;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import java.lang.String;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<String> createTransaction(
            @RequestBody CreateUserRequest userRequest

    ) {
        User user = new User();
        user.setName(userRequest.getName());

        userService.saveUser(user);
        return new ResponseEntity<String>("Create Success  ", HttpStatus.CREATED);
    }


}
