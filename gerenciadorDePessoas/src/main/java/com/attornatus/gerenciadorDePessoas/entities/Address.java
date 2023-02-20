package com.attornatus.gerenciadorDePessoas.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "address")
@Entity
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String place;

    private int zipCode;

    private String number;

    private String city;

    @JsonManagedReference
    @ManyToOne
    private Person person;

    public Address(String place, int zipCode, String number, String city, Person person) {
        this.place = place;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.person = person;
    }
}
