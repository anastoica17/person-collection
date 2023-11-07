package com.learning.collection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.collection.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
