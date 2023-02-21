package com.attornatus.gerenciadorDePessoas.services;

import com.attornatus.gerenciadorDePessoas.dtos.AddressDto;
import com.attornatus.gerenciadorDePessoas.entities.Address;
import com.attornatus.gerenciadorDePessoas.entities.Person;
import com.attornatus.gerenciadorDePessoas.repositories.AddressRepository;
import com.attornatus.gerenciadorDePessoas.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Transactional
    public Address registerAddress(AddressDto addressDto){
        checkMainAddress(addressDto);
        Address address = addressRepository.save(convertObject(addressDto, personRepository));
        return address;
    }

    /*Dtos object conversion*/
    public Address convertObject(AddressDto addressDto, PersonRepository personRepository){
        Optional<Person> person = personRepository.findById(addressDto.getPersonId());
        return new Address(addressDto.getPlace(),
                addressDto.getZipCode(),
                addressDto.getNumber(),
                addressDto.getCity(),
                person.get(),
                addressDto.isMainAddress());
    }

    /*Method to fetch address po id*/
    public Address searchAddressById(Long id){
        Address address = addressRepository.findById(id).orElse(null);
        if (address == null){
            throw new RuntimeException("Address Not Found!");
        }
        return address;
    }

    /*Method to search all addresses.*/
    public List<Address> fetchAllAddresses(){
        return addressRepository.findAll();
    }

    /*Method to search addresses by person*/
    public List<Address> fetchAddressesPerson(Long id){
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()){
            return addressRepository.findAll()
                    .stream()
                    .filter(e -> e.getPerson().getId() == id)
                    .collect(Collectors.toList());
        }else {
            return null;
        }
    }
    public void checkMainAddress(AddressDto addressDto){
        Address addressNoSave = convertObject(addressDto, personRepository);
        if (addressNoSave.getMainAddress().equals(true)){
            List<Address> listingOfAddresses = fetchAddressesPerson(addressNoSave.getPerson().getId());
            for (Address listAddressesPerson : listingOfAddresses){
                if (listAddressesPerson.getMainAddress().equals(true)){
                    listAddressesPerson.setMainAddress(false);
                }
            }
        }
    }
}
