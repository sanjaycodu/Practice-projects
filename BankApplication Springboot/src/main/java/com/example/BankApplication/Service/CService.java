package com.example.BankApplication.Service;

import com.example.BankApplication.Entity.BnEntity;
import com.example.BankApplication.Repository.BnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CService {
    @Autowired
    BnRepository repo;

    public String create(String holder, int balance) {
        BnEntity entity = new BnEntity(holder, balance);
        repo.save(entity);
        return "created";
    }

    public List<BnEntity> getDetails() {
        return repo.findAll();
    }

    public BnEntity getDetails_by_id(int id) {
        Optional<BnEntity> account = repo.findById(id);
        if (account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        BnEntity acc = account.get();
        return acc;
    }

    public String deposit(int id, int amt) {
        Optional<BnEntity> account = repo.findById(id);
        if (account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        BnEntity acc = account.get();
        int total = acc.getBalance() + amt;
        acc.setBalance(total);
        repo.save(acc);
        return("Deposit Completed");
    }

    public String withdraw_amt(int id, int amt) {
        Optional<BnEntity> account = repo.findById(id);
        if (account.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }
        BnEntity acc = account.get();
        int total = acc.getBalance() - amt;
        acc.setBalance(total);
        repo.save(acc);
        return ("Withdraw Completed");
    }

    public String del_By_Id(int id) {
        getDetails_by_id(id);
        repo.deleteById(id);
        return ("Deleted Successfully");
    }

}
