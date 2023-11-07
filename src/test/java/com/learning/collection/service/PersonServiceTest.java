package com.learning.collection.service;

import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Function;
import java.util.function.Predicate;

import org.antlr.v4.runtime.misc.Triple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learning.collection.model.Person;


@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void getPersonsByGenderAndCountry() {
        var expectedPerson = Person.builder()
                                   .id(1L)
                                   .firstName("Edith")
                                   .lastName("Filippozzi")
                                   .email("efilippozzi0@salon.com")
                                   .gender("Female")
                                   .city("Ipuh")
                                   .country("Indonesia")
                                   .countryCode("ID")
                                   .phoneNumber("228-738-8028")
                                   .build();
        var expectedResult = new Triple("Female", "Indonesia", expectedPerson);

        var customList = personService.getPersonsByGenderAndCountry();
        assertThat(customList.get(0)).usingRecursiveComparison().isEqualTo(expectedResult);
    }

    @Test
    void shouldRetrieveOnlyFemale() {
        var persons = personService.findAll();
        Predicate<Person> onlyFemale = person -> person.getGender() == "Female";
        var femaleList = persons.stream()
                                .filter(onlyFemale)
                                .collect(toMap(Person::getGender, Function.identity()));

        assertThat(femaleList.get("Male")).isNull();
    }


}
