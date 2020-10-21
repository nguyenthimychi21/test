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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @PostMapping(path = "/{id}")
    public ResponseEntity<String> createTransaction(
            @PathVariable Long id,
            @RequestBody CreateTransactions transactionsRequest
    ) throws Exception {
        User user = userService.getUser(id);
        Account account = accountService.getId(transactionsRequest.getAccountId());
        if (account == null) {
            throw new Exception("Error 404 :Not Found");
        }
        {

            Transactions transaction = new Transactions();
            transaction.setAccountId(transactionsRequest.getAccountId());
            transaction.setAmount(transactionsRequest.getAmount());
            transaction.setTransactionType(transactionsRequest.getTransactionType());
            transaction.setCreateAt(new Date());
            transaction.setBank(account.getBank());
            transaction.setUserId(account.getUserId());
            transactionService.saveTransaction(transaction);
            return new ResponseEntity<String>("Create Success", HttpStatus.CREATED);
        }
    }


    //get all transactions by userid and acountid
    @GetMapping(path = "/{id}/{accountId}")
    public List<Transactions> getAllTransactionsByAccountId(
            @PathVariable Long id,
            @RequestParam(value = "account_id") Long accountId
    ) throws Exception {
        User user = userService.getUser(id);
        if (user == null) {
            throw new Exception("error");
        }
        return transactionService.getAllAcountId(accountId);
    }

    //put transaction by id
    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateDomain(
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
        return new ResponseEntity<String>("Update Success", HttpStatus.CREATED);
    }

    //delete transaction by id
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteTransactions(
            @PathVariable Long id) {
        Transactions transactions = transactionService.getId(id);
        transactionService.deleteTransactions(transactions);
        return new ResponseEntity<String>("Delete Success", HttpStatus.OK);
    }
}




