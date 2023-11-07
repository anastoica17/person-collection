package com.learning.collection.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.collection.model.Person;
import com.learning.collection.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    List<Person> all() {
        return personService.findAll();
    }

    @GetMapping("/{firstName}")
    List<Person> findByName(@PathVariable String firstName) {return personService.findByName(firstName);}

    @GetMapping("/{gender}/{countryCode}")
    List<Person> findByCountryCodeAndGender(@PathVariable String gender, @PathVariable String countryCode) {
        return personService.findByCountryCodeAndGender(countryCode, gender);
    }
}
