package org.example.DTO;

import lombok.Data;

@Data
public class CustomerDto {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String address;
}
