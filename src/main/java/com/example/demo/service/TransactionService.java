package com.example.demo.service;

import com.example.demo.entity.Transactions;

import javax.transaction.Transaction;
import java.util.List;

public interface TransactionService {
    Transactions saveTransaction(Transactions transaction );
    Transactions getId(Long id);
    List<Transactions> getAllAcountId(Long accountId);
    void deleteTransactions(Transactions transactions);
    List<Transactions> getAll();

}
