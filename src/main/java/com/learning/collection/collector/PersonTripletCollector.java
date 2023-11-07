package com.learning.collection.collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import org.antlr.v4.runtime.misc.Triple;
import org.springframework.data.util.Pair;

import com.learning.collection.model.Person;

public class PersonTripletCollector implements Collector<Person, List<Triple<String, String, Person>>, List<Triple<String, String, Person>>> {
    @Override
    public Supplier<List<Triple<String, String, Person>>> supplier() {
        return ArrayList::new;
    }

    public static PersonTripletCollector personTripletCollector() {
        return new PersonTripletCollector();
    }

    @Override
    public BiConsumer<List<Triple<String, String, Person>>, Person> accumulator() {
        return (list, person) -> list.add(new Triple(person.getGender(), person.getCountry(), person));
    }

    @Override
    public BinaryOperator<List<Triple<String, String, Person>>> combiner() {
        return (firstList, secondList) -> {
            firstList.addAll(secondList);
            return firstList;
        };
    }

    @Override
    public Function finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
    }
}
