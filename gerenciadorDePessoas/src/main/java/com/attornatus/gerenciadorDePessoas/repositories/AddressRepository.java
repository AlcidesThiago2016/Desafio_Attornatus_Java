package com.attornatus.gerenciadorDePessoas.repositories;

import com.attornatus.gerenciadorDePessoas.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
