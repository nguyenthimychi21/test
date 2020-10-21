package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getId(Long id) {
        Optional<Account> accountResponse = accountRepository.findById(id);
        Account account = accountResponse.get();
        return account;

        //  return accountRepository.findAllById(id);
    }
}
