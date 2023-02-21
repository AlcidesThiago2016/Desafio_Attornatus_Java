package com.attornatus.gerenciadorDePessoas.controllers;

import com.attornatus.gerenciadorDePessoas.dtos.PersonDto;
import com.attornatus.gerenciadorDePessoas.entities.Person;
import com.attornatus.gerenciadorDePessoas.repositories.PersonRepository;
import com.attornatus.gerenciadorDePessoas.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/registerPerson")
    public ResponseEntity<Person> registerPerson(@RequestBody @Valid PersonDto personDto){
        return new ResponseEntity<Person>(personService.registerPerson(personDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/searchPerson/{id}")
    public ResponseEntity<Person> fetchPersonById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<Person>(personService.fetchPersonById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/editPerson/{id}")
    public ResponseEntity<Person> editPerson(@PathVariable(value = "id") Long id, @RequestBody @Valid PersonDto personDto){
        return new ResponseEntity<Person>(personService.editPerson(personDto, id),HttpStatus.OK);
    }

    @GetMapping(value = "/listPerson")
    public ResponseEntity<List<Person>> listPerson(){
        return new ResponseEntity<List<Person>>(personService.searchPeople(), HttpStatus.OK);
    }
}
