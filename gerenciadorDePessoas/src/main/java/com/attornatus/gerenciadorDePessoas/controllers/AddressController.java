package com.attornatus.gerenciadorDePessoas.controllers;

import com.attornatus.gerenciadorDePessoas.dtos.AddressDto;
import com.attornatus.gerenciadorDePessoas.entities.Address;
import com.attornatus.gerenciadorDePessoas.repositories.AddressRepository;
import com.attornatus.gerenciadorDePessoas.repositories.PersonRepository;
import com.attornatus.gerenciadorDePessoas.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressService addressService;

    @PostMapping(value = ("/registerAddress"))
    public ResponseEntity<Address> registerAddress(@RequestBody @Valid AddressDto addressDto){
        return new ResponseEntity<Address>(addressService.registerAddress(addressDto), HttpStatus.CREATED);
    }

    @GetMapping(value = ("/searchAddress/{id}"))
    public ResponseEntity<Address> searchAddress(@PathVariable(value = "id") Long id){
        return new ResponseEntity<Address>(addressService.searchAddressById(id), HttpStatus.OK);
    }

    @GetMapping(value = ("/listAddresses"))
    public ResponseEntity<List<Address>>listAddresses(){
        return new ResponseEntity<List<Address>>(addressService.fetchAllAddresses(), HttpStatus.OK);
    }

    @GetMapping(value = ("/listAddressesByPerson/{id}"))
    public ResponseEntity<List<Address>>listAddressesByPerson(@PathVariable(value = "id") Long id){
        return new ResponseEntity<List<Address>>(addressService.fetchAddressesPerson(id), HttpStatus.OK);
    }

}
