package org.example.Services;


import org.example.DTO.TransactionDto;
import org.example.Mapper.TransactionMapper;
import org.example.Model.Account;
import org.example.Model.Transaction;
import org.example.Repositories.AccountRepository;
import org.example.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private  final TransactionMapper transactionMapper;
    private static TransactionRepository transactionRepository;
    private static AccountRepository accountRepository;

    @Autowired
    public TransactionService(TransactionMapper transactionMapper, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionMapper = transactionMapper;
        TransactionService.transactionRepository = transactionRepository;
        TransactionService.accountRepository = accountRepository;
    }

    public TransactionDto createTransaction(Transaction transaction){

        Account account = new Account();
        double amount = transaction.getAmount();

        if (transaction.getType().equals("deposit")){
            account.setBalance(account.getBalance()+amount);
        }

        else if (transaction.getType().equals("withdraw")&& account.getBalance()>amount ) {
            account.setBalance(account.getBalance()-amount);

        }
        else {
            throw new IllegalArgumentException("Invalid transaction type");
        }
        return transactionMapper.mapToDto(transactionRepository.save(transaction));

    }
    public static List<Transaction> getAccountTransactions(Long accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        return transactionRepository.findByAccount(account);

    }



}
