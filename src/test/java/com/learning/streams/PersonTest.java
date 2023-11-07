package com.learning.streams;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learning.collection.model.Person;
import com.learning.collection.service.PersonService;

class PersonTest {


    private static Person[] arrayOfPersons = {
            Person.builder().id(1L).firstName("p1").lastName("p1").email("p1@mail.com").gender("FEMALE").city("London").country("UK").countryCode("UK").phoneNumber("12345").build(),
            Person.builder().id(2L).firstName("p2").lastName("p2").email("p2@mail.com").gender("MALE").city("London").country("UK").countryCode("UK").phoneNumber("23245").build(),
            Person.builder().id(3L).firstName("p2").lastName("p2").email("p3@mail.com").gender("MALE").city("Belfast").country("UK").countryCode("UK").phoneNumber("1223234345").build(),
            Person.builder().id(4L).firstName("p3").lastName("p3").email("p3@mail.com").gender("FEMALE").city("Bath").country("UK").countryCode("UK").phoneNumber("1223232345").build()
    };
    @Test
    void filterAllPersonsLocatedInUKButNotLondon() {
        var personList = Arrays.stream(arrayOfPersons).toList();

        var notLondon = personList.stream()
                                  .filter(person -> person.getCountryCode().equals("UK") && person.getCity().equals("London")) //intermediate operation
                                  .toList(); //final operation

        assertThat(notLondon.size()).isEqualTo(2);
    }


    //https://reflectoring.io/java-completablefuture/
    // example for using streams with completableFuture

    @Test
    void createCustomCollector() {


    }
}
