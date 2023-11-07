package com.learning.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

/**
 * * Simply put, the TreeSet is a sorted collection that extends the AbstractSet class and implements the
 * NavigableSet interface.
 * <p>
 * Here’s a quick summary of the most important aspects of this implementation:
 * <p>
 * It stores unique elements
 * It doesn’t preserve the insertion order of the elements
 * It sorts the elements in ascending order
 * It’s not thread-safe
 * In this implementation, objects are sorted and stored in ascending order according to their natural
 * * order. The TreeSet uses a self-balancing binary search tree, more specifically a Red-Black tree.
 */
class TreeSetTest {

    @Test
    public void whenCheckingForElement_shouldSearchForElement() {
        Set<String> treeSetContains = new TreeSet<>();
        treeSetContains.add("String Added");

        assertTrue(treeSetContains.contains("String Added"));
    }

    @Test
    public void whenCheckingForElement_shouldContainElement() {
        Set<String> treeSetContains = new TreeSet<>();
        treeSetContains.add("String Added");

        assertTrue(treeSetContains.contains("String Added"));
    }

    @Test
    public void whenRemovingElement_shouldRemoveElement() {
        Set<String> removeFromTreeSet = new TreeSet<>();
        removeFromTreeSet.add("String Added");

        assertTrue(removeFromTreeSet.remove("String Added"));
    }

    @Test
    public void whenClearingTreeSet_shouldClearTreeSet() {
        Set<String> clearTreeSet = new TreeSet<>();
        clearTreeSet.add("String Added");
        clearTreeSet.clear();

        assertTrue(clearTreeSet.isEmpty());
    }

    @Test
    public void whenCheckingTheSizeOfTreeSet_shouldReturnThesize() {
        Set<String> treeSetSize = new TreeSet<>();
        treeSetSize.add("String Added");

        assertEquals(1, treeSetSize.size());
    }

    @Test
    public void whenIteratingTreeSet_shouldIterateTreeSetInAscendingOrder() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    public void whenModifyingTreeSetWhileIterating_shouldThrowException() {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();

        assertThrows(ConcurrentModificationException.class, () -> {
            while (itr.hasNext()) {
                itr.next();
                treeSet.remove("Second");
            }
        });
    }

    @Test
    public void whenRemovingElementUsingIterator_shouldRemoveElement() {

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("First");
        treeSet.add("Second");
        treeSet.add("Third");
        Iterator<String> itr = treeSet.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            if (element.equals("Second"))
                itr.remove();
        }

        assertEquals(2, treeSet.size());
    }

    @Test
    public void whenUsingSubSet_shouldReturnSubSetElements() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> expectedSet = new TreeSet<>();
        expectedSet.add(2);
        expectedSet.add(3);
        expectedSet.add(4);
        expectedSet.add(5);

        Set<Integer> subSet = treeSet.subSet(2, 6);

        assertEquals(expectedSet, subSet);
    }

    @Test
    public void whenUsingHeadSet_shouldReturnHeadSetElements() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);

        Set<Integer> subSet = treeSet.headSet(5);

        assertEquals(subSet, treeSet.subSet(1, 5));
    }
}
