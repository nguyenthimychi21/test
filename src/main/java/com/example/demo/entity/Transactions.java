package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transactions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private
    Long id;
    @Column(name="user_id")
    private Long userId;
    @Column(name="account_id")
    private
    Long accountId;
    @Column(name="amount")
    private
    int amount;
    @Column(name="bank")
    private
    String bank;
    @Column(name=" transaction_type")
    private
    String transactionType;
    @Column(name="create_at")
    private
    Date createAt;


}
