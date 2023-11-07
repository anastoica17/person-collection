package com.learning.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/**
 * * Let’s first look at what it means that HashMap is a map. A map is a key-value mapping, which means that every key is mapped to exactly one value and that we can use the key to retrieve the corresponding value from a map.
 * <p>
 * One might ask why not simply add the value to a list. Why do we need a HashMap? The simple reason is performance. If we want to find a specific element in a list, the time complexity is O(n) and if the list is sorted, it will be O(log n) using, for example, a binary search.
 * <p>
 * The advantage of a HashMap is that the time complexity to insert and retrieve a value is O(1) on average. We’ll look at how that can be achieved later
 * <p>
 * the HashMap which is a hashtable-based implementation. It extends the AbstractMap class and implements the Map interface. A HashMap works on the principle of hashing.
 * <p>
 * This Map implementation usually acts as a bucketed hash table, but when buckets get too large, they get transformed into nodes of TreeNodes, each structured similarly to those in java.util.TreeMap.
 * <p>
 * the HashMap which is a hashtable-based implementation. It extends the AbstractMap class and implements the Map interface. A HashMap works on the principle of hashing.
 * <p>
 * This Map implementation usually acts as a bucketed hash table, but when buckets get too large, they get transformed into nodes of TreeNodes, each structured similarly to those in java.util.TreeMap.
 * <p>
 * The value for TREEIFY_THRESHOLD is eight which effectively denotes the threshold count for using a tree rather than a linked list for a bucket.
 * <p>
 * It is evident that:
 * <p>
 * A HashMap requires way more memory than is needed to hold its data
 * A HashMap shouldn’t be more than 70% – 75% full. If it gets close, it gets resized and entries rehashed
 * Rehashing requires n operations which is costly wherein our constant time insert becomes of order O(n)
 * It’s the hashing algorithm which determines the order of inserting the objects in the HashMap
 * The performance of a HashMap can be tuned by setting the custom initial capacity and the load factor, at the time of HashMap object creation itself.
 * <p>
 * However, we should choose a HashMap if:
 * <p>
 * <p>
 * freestar
 * ADVERTISING
 * <p>
 * <p>
 * we know approximately how many items to maintain in our collection
 * we don’t want to extract items in a natural order
 * Under the above circumstances, HashMap is our best choice because it offers constant time insertion, search, and deletion.
 * <p>
 * 3.2. TreeMap
 * A TreeMap stores its data in a hierarchical tree with the ability to sort the elements with the help of a custom Comparator.
 * <p>
 * A summary of its performance:
 * <p>
 * TreeMap provides a performance of O(log(n)) for most operations like add(), remove() and contains()
 * A Treemap can save memory (in comparison to HashMap) because it only uses the amount of memory needed to hold its items, unlike a HashMap which uses contiguous region of memory
 * A tree should maintain its balance in order to keep its intended performance, this requires a considerable amount of effort, hence complicates the implementation
 * We should go for a TreeMap whenever:
 * <p>
 * memory limitations have to be taken into consideration
 * we don’t know how many items have to be stored in memory
 * we want to extract objects in a natural order
 * if items will be consistently added and removed
 * we’re willing to accept O(log n) search time
 * 4. Similarities
 * 4.1. Unique Elements
 * Both TreeMap and HashMap don’t support duplicate keys. If added, it overrides the previous element (without an error or an exception):
 */

/**
 * the HashMap which is a hashtable-based implementation. It extends the AbstractMap class and implements the Map interface. A HashMap works on the principle of hashing.
 * <p>
 * This Map implementation usually acts as a bucketed hash table, but when buckets get too large, they get transformed into nodes of TreeNodes, each structured similarly to those in java.util.TreeMap.
 */

/**
 * The value for TREEIFY_THRESHOLD is eight which effectively denotes the threshold count for using a tree rather than a linked list for a bucket.
 *
 * It is evident that:
 *
 * A HashMap requires way more memory than is needed to hold its data
 * A HashMap shouldn’t be more than 70% – 75% full. If it gets close, it gets resized and entries rehashed
 * Rehashing requires n operations which is costly wherein our constant time insert becomes of order O(n)
 * It’s the hashing algorithm which determines the order of inserting the objects in the HashMap
 * The performance of a HashMap can be tuned by setting the custom initial capacity and the load factor, at the time of HashMap object creation itself.
 *
 * However, we should choose a HashMap if:
 *
 *
 * freestar
 * ADVERTISING
 *
 *
 * we know approximately how many items to maintain in our collection
 * we don’t want to extract items in a natural order
 * Under the above circumstances, HashMap is our best choice because it offers constant time insertion, search, and deletion.
 *
 * 3.2. TreeMap
 * A TreeMap stores its data in a hierarchical tree with the ability to sort the elements with the help of a custom Comparator.
 *
 * A summary of its performance:
 *
 * TreeMap provides a performance of O(log(n)) for most operations like add(), remove() and contains()
 * A Treemap can save memory (in comparison to HashMap) because it only uses the amount of memory needed to hold its items, unlike a HashMap which uses contiguous region of memory
 * A tree should maintain its balance in order to keep its intended performance, this requires a considerable amount of effort, hence complicates the implementation
 * We should go for a TreeMap whenever:
 *
 * memory limitations have to be taken into consideration
 * we don’t know how many items have to be stored in memory
 * we want to extract objects in a natural order
 * if items will be consistently added and removed
 * we’re willing to accept O(log n) search time
 * 4. Similarities
 * 4.1. Unique Elements
 * Both TreeMap and HashMap don’t support duplicate keys. If added, it overrides the previous element (without an error or an exception):
 */

/**
 * * Which Implementation to Use?
 * In general, both implementations have their respective pros and cons, however, it’s about understanding the underlying expectation and requirement which must govern our choice regarding the same.
 *
 * Summarizing:
 *
 * We should use a TreeMap if we want to keep our entries sorted
 * We should use a HashMap if we prioritize performance over memory consumption
 * Since a TreeMap has a more significant locality, we might consider it if we want to access objects that are relatively close to each other according to their natural ordering
 * HashMap can be tuned using the initialCapacity and loadFactor, which isn’t possible for the TreeMap
 * We can use the LinkedHashMap if we want to preserve insertion order while benefiting from constant time access
 */
class HashMapTest {

    //todo: hashtable

    @Test
    void givenNullKeyAndVal_whenAccepts_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
    }

    @Test
    void givenExistingKey_whenPutReturnsPrevValue_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "val1");

        String rtnVal = map.put("key1", "val2");

        assertEquals("val1", rtnVal);
    }

    @Test
    void givenNewKey_whenPutReturnsNull_thenCorrect() {
        Map<String, String> map = new HashMap<>();

        String rtnVal = map.put("key1", "val1");

        assertNull(rtnVal);
        assertEquals("val1", map.get("key1"));
    }

    @Test
    void whenContainsDistinguishesNullValues_thenCorrect() {
        Map<String, String> map = new HashMap<>();

        String val1 = map.get("key");
        boolean valPresent = map.containsKey("key");

        assertNull(val1);
        assertFalse(valPresent);

        map.put("key", null);
        String val = map.get("key");
        valPresent = map.containsKey("key");

        assertNull(val);
        assertTrue(valPresent);
    }

    @Test
    void givenHashMap_whenRetrievesKeyset_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Set<String> keys = map.keySet();

        assertEquals(2, keys.size());
        assertTrue(keys.contains("name"));
        assertTrue(keys.contains("type"));
    }

    @Test
    public void givenKeySet_whenChangeReflectsInMap_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        assertEquals(2, map.size());

        Set<String> keys = map.keySet();
        keys.remove("name");

        assertEquals(1, map.size());
    }

    @Test
    public void givenHashMap_whenRetrievesValues_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Collection<String> values = map.values();

        assertEquals(2, values.size());
        assertTrue(values.contains("baeldung"));
        assertTrue(values.contains("blog"));
    }

    @Test
    public void givenHashMap_whenRetrievesEntries_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        assertEquals(2, entries.size());
        for (Map.Entry<String, String> e : entries) {
            String key = e.getKey();
            String val = e.getValue();
            assertTrue(key.equals("name") || key.equals("type"));
            assertTrue(val.equals("baeldung") || val.equals("blog"));
        }
    }

    @Test
    void givenIterator_whenFailsFastOnModification_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        assertThrows(ConcurrentModificationException.class, () -> {
            Set<String> keys = map.keySet();
            Iterator<String> it = keys.iterator();
            map.remove("type");
            while (it.hasNext()) {
                it.next();
            }
        });
    }

    @Test
    public void whenCallsEqualsOnCollision_thenCorrect() {
        HashMap<MyKey, String> map = new HashMap<>();
        MyKey k1 = new MyKey(1, "firstKey");
        MyKey k2 = new MyKey(2, "secondKey");
        MyKey k3 = new MyKey(2, "thirdKey");

        System.out.println("storing value for k1");
        map.put(k1, "firstValue");
        System.out.println("storing value for k2");
        map.put(k2, "secondValue");
        System.out.println("storing value for k3");
        map.put(k3, "thirdValue");

        System.out.println("retrieving value for k1");
        String v1 = map.get(k1);
        System.out.println("retrieving value for k2");
        String v2 = map.get(k2);
        System.out.println("retrieving value for k3");
        String v3 = map.get(k3);

        assertEquals("firstValue", v1);
        assertEquals("secondValue", v2);
        assertEquals("thirdValue", v3);
    }

    @Test
    void whenCallsEqualsOnCollision_thenCorrect2() {
        HashMap<MyKey, String> map = new HashMap<>();
        MyKey k1 = new MyKey(1, "firstKey");
        MyKey k2 = new MyKey(2, "secondKey");
        MyKey k3 = new MyKey(2, "thirdKey");

        System.out.println("storing value for k1");
        map.put(k1, "firstValue");
        System.out.println("storing value for k2");
        map.put(k2, "secondValue");
        System.out.println("storing value for k3");
        map.put(k3, "thirdValue");

        System.out.println("retrieving value for k1");
        String v1 = map.get(k1);
        System.out.println("retrieving value for k2");
        String v2 = map.get(k2);
        System.out.println("retrieving value for k3");
        String v3 = map.get(k3);

        assertEquals("firstValue", v1);
        assertEquals("secondValue", v2);
        assertEquals("thirdValue", v3);
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    public static class MyKey {
        private int    id;
        private String name;
    }
}
