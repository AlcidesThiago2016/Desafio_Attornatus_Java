package com.attornatus.gerenciadorDePessoas.dtos;

import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String name;
    private Date dateOfBirth;
}
