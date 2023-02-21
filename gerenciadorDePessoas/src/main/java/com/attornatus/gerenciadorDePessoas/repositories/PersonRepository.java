package com.attornatus.gerenciadorDePessoas.repositories;

import com.attornatus.gerenciadorDePessoas.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
