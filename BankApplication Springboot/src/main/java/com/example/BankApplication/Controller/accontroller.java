package com.example.BankApplication.Controller;

import com.example.BankApplication.Entity.BnEntity;
import com.example.BankApplication.Service.CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins =  "http://127.0.0.1:5500/")
public class accontroller {

    @Autowired
    CService cService;

    @PostMapping("/create")
    String Bncreate(
            @RequestParam("holder") String holder,
            @RequestParam("balance") int balance) {
        return cService.create(holder, balance);
    }

    @GetMapping("details")
    List<BnEntity> getAll() {
        return cService.getDetails();
    }

    @GetMapping("detailsId/{id}")
    BnEntity getId(@PathVariable int id) {
        return cService.getDetails_by_id(id);
    }

    @PutMapping("/deposit/{id}/{amt}")
    String update(@PathVariable int id, @PathVariable int amt) {
        return cService.deposit(id, amt);
    }

    @PutMapping("/withdraw/{id}/{amt}")
    String withdraw(@PathVariable int id, @PathVariable int amt) {
        return cService.withdraw_amt(id, amt);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletById(@PathVariable int id) {
        cService.del_By_Id(id);
//    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account closed"); (or)
        return ResponseEntity.ok("Account closed");
    }
}
