package com.learning;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.WeakHashMap;

import org.junit.jupiter.api.Test;

public class ReferenceTest {
    /**
     * 2.1. Strong References
     * The strong reference is the most common type of Reference that we use in our day to day programming:
     *
     * Integer prime = 1;
     * Copy
     * The variable prime has a strong reference to an Integer object with value 1.
     * * Any object which has a strong reference pointing to it is not eligible for GC.
     */
/**
 * 2.2. Soft References*
 * Simply put, an object that has a SoftReference pointing to it won’t be garbage collected until the JVM absolutely needs memory.
 * <p>
 * Let’s see how we can create a SoftReference in Java:
 * <p>
 * Integer prime = 1;
 * SoftReference<Integer> soft = new SoftReference<Integer>(prime);
 * prime = null;
 * <p>
 * 2.3. Weak References
 * The objects that are referenced only by weak references are garbage collected eagerly; the GC won’t wait until it needs memory in that case.
 * <p>
 * We can create a WeakReference in Java in the following way:
 * <p>
 * Integer prime = 1;
 * WeakReference<Integer> soft = new WeakReference<Integer>(prime);
 * prime = null;
 * Copy
 * When we made a prime reference null, the prime object will be garbage collected in the next GC cycle, as there is no other strong reference pointing to it.
 */

    /**
     * 2.3. Weak References
     * The objects that are referenced only by weak references are garbage collected eagerly; the GC won’t wait until it needs memory in that case.
     * <p>
     * We can create a WeakReference in Java in the following way:
     * <p>
     * Integer prime = 1;
     * WeakReference<Integer> soft = new WeakReference<Integer>(prime);
     * prime = null;
     * Copy
     * When we made a prime reference null, the prime object will be garbage collected in the next GC cycle, as there is no other strong reference pointing to it.
     */

    @Test
    void weakReference() {
        WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        BigImage bigImage = new BigImage("image_id");
        UniqueImageName imageName = new UniqueImageName("name_of_big_image");

        map.put(imageName, bigImage);
        assertTrue(map.containsKey(imageName));

        imageName = null;
        System.gc();

        //  Async.await().atMost(10, TimeUnit.SECONDS).until(map::isEmpty);
    }

    @Test
    void NullName() {
        WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        BigImage bigImageFirst = new BigImage("foo");
        UniqueImageName imageNameFirst = new UniqueImageName("name_of_big_image");

        BigImage bigImageSecond = new BigImage("foo_2");
        UniqueImageName imageNameSecond = new UniqueImageName("name_of_big_image_2");

        map.put(imageNameFirst, bigImageFirst);
        map.put(imageNameSecond, bigImageSecond);

        assertTrue(map.containsKey(imageNameFirst));
        assertTrue(map.containsKey(imageNameSecond));

        imageNameFirst = null;
        System.gc();

        //  await().atMost(10, TimeUnit.SECONDS)
        //          .until(() -> map.size() == 1);
        //    await().atMost(10, TimeUnit.SECONDS)
        //            .until(() -> map.containsKey(imageNameSecond));
    }

    record BigImage(String imageId) {
    }

    record UniqueImageName(String name) {
    }
}