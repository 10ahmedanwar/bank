package org.example.Controllers;


import org.example.DTO.TransactionDto;
import org.example.Model.Transaction;
import org.example.Services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {


    private final TransactionService transactionService;


    public TransactionController( TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/createTransation")
    public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction){
        return ResponseEntity.ok("Transaction created successfully");
    }
    @GetMapping("/{accountId}/transactions")
    public List<Transaction> getAccountTransactions(@PathVariable Long accountId) {
        return TransactionService.getAccountTransactions(accountId);
    }
}
