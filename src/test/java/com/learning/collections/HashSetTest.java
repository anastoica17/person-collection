package com.learning.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * * HashSet is one of the fundamental data structures in the Java Collections API.
 * <p>
 * Let’s recall the most important aspects of this implementation:
 * <p>
 * It stores unique elements and permits nulls
 * It’s backed by a HashMap
 * It doesn’t maintain insertion order
 * It’s not thread-safe
 */

/**
 * * How HashSet Maintains Uniqueness?
 * When we put an object into a HashSet, it uses the object’s hashcode value to determine if an element is not in the set already.
 * <p>
 * Each hash code value corresponds to a certain bucket location which can contain various elements, for which the calculated hash value is the same. But two objects with the same hashCode might not be equal.
 * So, objects within the same bucket will be compared using the equals() method.
 */
class HashSetTest {

    @Test
    void whenIteratingHashSet_shouldIterateHashSet() {
        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        Iterator<String> itr = hashset.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    void whenModifyingHashSetWhileIterating_shouldThrowException() {

        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        Iterator<String> itr = hashset.iterator();

        assertThrows(ConcurrentModificationException.class, () -> {
            while (itr.hasNext()) {
                itr.next();
                hashset.remove("Second");
            }
        });
    }

    @Test
    public void whenRemovingElementUsingIterator_shouldRemoveElement() {

        Set<String> hashset = new HashSet<>();
        hashset.add("First");
        hashset.add("Second");
        hashset.add("Third");
        Iterator<String> itr = hashset.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            if (element.equals("Second"))
                itr.remove();
        }

        assertEquals(2, hashset.size());
    }

}
