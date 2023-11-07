package com.learning.collection.service;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.misc.Triple;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.learning.collection.collector.PersonTripletCollector;
import com.learning.collection.model.Person;
import com.learning.collection.repository.PersonRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findByName(String firstName) {
        var allPersons = personRepository.findAll();
        return allPersons.stream().filter(person -> person.getFirstName().contains(firstName))
                         .toList();
    }

    public List<Person> findByCountryCodeAndGender(String countryCode, String gender) {
        var allPersons = personRepository.findAll();
        var personsByGender = allPersons.stream().collect(groupingBy(Person::getGender));
        var females = personsByGender.get("Female").stream().count();
        var males = personsByGender.get("Male").stream().count();
        log.info("females :" + females);
        log.info("males : " + males);
        return personsByGender.get(gender)
                              .stream().filter(person -> person.getCountryCode().toLowerCase(Locale.ROOT).equals(countryCode.toLowerCase(Locale.ROOT)))
                              .toList();
    }

    public List<Triple<String, String, Person>> getPersonsByGenderAndCountry() {
        var allPersons = personRepository.findAll();
        return allPersons.stream()
                         .collect(PersonTripletCollector.personTripletCollector());
    }

    //multimap
}
