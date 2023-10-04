package org.example.DTO;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.Model.Account;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TransactionDto {

    private int id;
    private double amount;
    private String type;
    private Date timestamp;
    private String notes;
    private Account account;

}
