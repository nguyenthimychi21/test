package com.example.demo.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UpdateTransactionsRequest {

    private Long userId;
    private Long accountId;
    private int amount;
    private String bank;
    private String transactionType;
    private Date createAt;
}
