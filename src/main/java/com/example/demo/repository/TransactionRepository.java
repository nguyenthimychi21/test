package com.example.demo.repository;

import com.example.demo.entity.Transactions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TransactionRepository extends CrudRepository<Transactions, Long> {

    List<Transactions> findByAccountId(Long accountId);

}
