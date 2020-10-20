package com.example.demo.service;

import com.example.demo.entity.Transactions;

import java.util.List;

public interface TransactionService {
    Transactions saveTransaction(Transactions transaction );
    Transactions getId(Long id);
    List<Transactions> getAllAcountId(Long accountId);
    Transactions deleteTransactions(Transactions transactions);
    List<Transactions> getAll();

}
