package org.example.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String cardNumber;
    private String password;
    private double balance;
    @ManyToOne
    private Customer customer;

}
