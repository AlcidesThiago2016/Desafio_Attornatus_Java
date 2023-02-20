package com.attornatus.gerenciadorDePessoas.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "person")
@Entity
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Id
    @Column(name = "date_birth")
    private Date dateOfBirth;

    @JsonManagedReference
    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    public Person(String name, Date dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
