package com.example.BankApplication.Entity;

import jakarta.persistence.*;

@Entity
@Table
public class BnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    public BnEntity(String holder, int balance) {
        this.holder = holder;
        this.balance = balance;
    }

    public BnEntity() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Column
    private String holder;
    @Column
    private int balance;

}
