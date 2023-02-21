package com.attornatus.gerenciadorDePessoas.services;

import com.attornatus.gerenciadorDePessoas.dtos.PersonDto;
import com.attornatus.gerenciadorDePessoas.entities.Person;
import com.attornatus.gerenciadorDePessoas.repositories.AddressRepository;
import com.attornatus.gerenciadorDePessoas.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private AddressRepository addressRepository;

    @Transactional
    public Person registerPerson(PersonDto personDto){
        Person person = personRepository.save(convertObject(personDto));
        return person;
    }

    @Transactional
    public Person editPerson(PersonDto personDto, Long id){
        Person person = personRepository.findById(id).orElse(null);
        if (person == null){
            throw new RuntimeException("Person Not Found!");
        }
        person.setName(personDto.getName());
        person.setDateOfBirth(personDto.getDateOfBirth());
        personRepository.save(person);
        return person;
    }
    public Person convertObject(PersonDto personDto){
        return new Person(personDto.getName(),
                personDto.getDateOfBirth());
    }

    public Person fetchPersonById(Long idPerson){
        Person person = personRepository.findById(idPerson).orElse(null);
        if (person == null){
            throw new RuntimeException("Person Not Found!");
        }
        return person;
    }

    public List<Person> searchPeople(){
        return personRepository.findAll();
    }

}
