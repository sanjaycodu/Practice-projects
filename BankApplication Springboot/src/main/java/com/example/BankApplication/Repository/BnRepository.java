package com.example.BankApplication.Repository;

import com.example.BankApplication.Entity.BnEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BnRepository extends JpaRepository<BnEntity,Integer> {

}
