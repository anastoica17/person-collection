package com.learning.collection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Id
    private Long   id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String city;
    private String country;
    private String countryCode;
    private String phoneNumber;

}
