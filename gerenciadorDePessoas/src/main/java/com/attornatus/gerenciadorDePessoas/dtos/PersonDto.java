package com.attornatus.gerenciadorDePessoas.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @NotBlank
    private String name;
    private Date dateOfBirth;
}
