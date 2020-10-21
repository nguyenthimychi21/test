package com.example.demo.service.impl;

import com.example.demo.entity.Transactions;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public Transactions saveTransaction(Transactions transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transactions getId(Long id) {
        Optional<Transactions> transactionsRespon = transactionRepository.findById(id);
        Transactions transactions = transactionsRespon.get();
        return transactions;
        //return transactionRepository.findAllById(id);
    }

    @Override
    public List<Transactions> getAllAcountId(Long accountId) {
        return (List<Transactions>) transactionRepository.findByAccountId(accountId);
    }

    @Override
    public Transactions deleteTransactions(Transactions transactions) {
        transactionRepository.delete(transactions);
        return transactions;
    }

    @Override
    public List<Transactions> getAll() {
        return (List<Transactions>) transactionRepository.findAll();
    }
}
