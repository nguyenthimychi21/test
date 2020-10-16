package com.example.demo.controller;

import com.example.demo.controller.request.CreateTransactions;
import com.example.demo.controller.request.UpdateTransactionsRequest;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.entity.Transactions;
import com.example.demo.service.AccountService;
import com.example.demo.service.TransactionService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;

    //create transactions
    @PostMapping(path = "/{user}/{id}")
    public void createTransaction(
            @PathVariable Long id,
            @RequestBody CreateTransactions transactionsRequest
    ) {
        User user = userService.getUser(id);
        Account account = accountService.getId(transactionsRequest.getAccountId());
        if (account != null && user != null) {

            Transactions transaction = new Transactions();
            transaction.setAccountId(transactionsRequest.getAccountId());
            transaction.setAmount(transactionsRequest.getAmount());
            transaction.setTransactionType(transactionsRequest.getTransactionType());
            transaction.setCreateAt(new Date());
            transaction.setBank(account.getBank());
            transaction.setUserId(account.getUserId());
            transactionService.saveTransaction(transaction);
        }
    }


    //get all transactions by userid and acountid
    @GetMapping(path = "/{user}/{id}/{accountId}")
    public List<Transactions> getAllTransactionsByAccountId(
            @PathVariable Long id,
            @RequestParam(value = "account_id") Long accountId
    ) {
        User user = userService.getUser(id);
        if (user == null) {
            return null;
        }
        return transactionService.getAllAcountId(accountId);
    }

    //put transaction by id

    @PutMapping(path = "/{id}")
    public void updateDomain(
            @PathVariable Long id,
            @RequestBody UpdateTransactionsRequest transactionsRequest

    ) {

        Transactions transactions = transactionService.getId(id);
        transactions.setUserId(transactionsRequest.getUserId());
        transactions.setBank(transactionsRequest.getBank());
        transactions.setAmount(transactionsRequest.getAmount());
        transactions.setAccountId(transactionsRequest.getAccountId());
        transactions.setTransactionType(transactionsRequest.getTransactionType());
        transactions.setCreateAt(new Date());
        transactionService.saveTransaction(transactions);
    }

    //delete transaction by id
    @DeleteMapping(path = "/{id}")
    public void deleteTransactions(
            @PathVariable Long id) {
        Transactions transactions = transactionService.getId(id);
        transactionService.deleteTransactions(transactions);
    }
}




