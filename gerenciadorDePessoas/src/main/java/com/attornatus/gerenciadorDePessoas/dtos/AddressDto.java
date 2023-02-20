package com.attornatus.gerenciadorDePessoas.dtos;

import lombok.Data;

@Data
public class AddressDto {

    private String place;
    private int zipCode;
    private String number;
    private String city;
    private long personId;
    boolean mainAddress;
}
