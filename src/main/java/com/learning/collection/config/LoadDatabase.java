package com.learning.collection.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.collection.model.Person;
import com.learning.collection.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {


    @Bean
    CommandLineRunner initDb(PersonRepository repository) {
        var persons = new ArrayList<Person>();
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("data/persons.json")) {
            ObjectMapper mapper = new ObjectMapper();
            persons.addAll(mapper.readValue(in, new TypeReference<List<Person>>() {
            }));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        repository.saveAll(persons);
        return args -> log.info("all saved");
    }
}
