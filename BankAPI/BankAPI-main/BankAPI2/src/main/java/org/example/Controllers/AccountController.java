package org.example.Controllers;


import org.example.DTO.AccountDto;
import org.example.Model.Account;
import org.example.Repositories.AccountRepository;
import org.example.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }

    @PostMapping("/add")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
         accountService.addAccount(account);
         return ResponseEntity.ok("Account created successfully");
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String cardNumber, @RequestParam String password) {
         accountService.login(cardNumber, password);
         return ResponseEntity.ok("account logged in successfully");
    }


    @GetMapping("/{accountId}/balance")
    public double getAccountBalance(@PathVariable Long accountId) {
        return accountService.getAccountBalance(accountId);

    }

    @GetMapping("/checkBalance")
    public boolean checkIfBalanceIsEnough(@RequestParam String cardNumber, @RequestParam String password, @RequestParam double amount) {
        return accountService.checkIfBalanceIsEnough(cardNumber, password, amount);

    }


}