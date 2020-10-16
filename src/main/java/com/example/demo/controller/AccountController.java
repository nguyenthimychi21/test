package com.example.demo.controller;

import com.example.demo.controller.request.CreateAccountRequest;
import com.example.demo.controller.request.CreateUserRequest;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.service.AccountService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
public class AccountController {
    @Autowired
    UserService userService;
    @Autowired
    AccountService accountService;

    @PostMapping()
    public void createTransaction(
            @RequestBody CreateAccountRequest accountRequest

    ) {
        User user = userService.getUser(accountRequest.getUserId());
        if (user != null) {
            Account account = new Account();
            account.setUserId(accountRequest.getUserId());
            account.setName(accountRequest.getName());
            account.setBank(accountRequest.getBank());
            accountService.saveAccount(account);

        }

    }
}
