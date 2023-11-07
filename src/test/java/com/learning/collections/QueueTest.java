package com.learning.collections;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

/**
 * LinkedList, PriorityQueue, ArrayBlockingQueue, DelayQueue, LinkedBlockingQueue, PriorityBlockingQueue
 */
class QueueTest {
    /**
     * *As we may infer from its name, we use PriorityQueue to maintain a defined ordering in a given collection: the first element (head) of the queue is the most minor element with respect to the ordering we specify.
     * * Every retrieval operation of the queue (poll, remove, or peek) reads the head of the queue.
     */

    @Test
    void priorityQueue() {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        PriorityQueue<Integer> integerQueueWithComparator = new PriorityQueue<>(Comparator.comparingInt((Integer c) -> c));

        integerQueueWithComparator.add(3);
        integerQueue.add(3);

        integerQueueWithComparator.add(2);
        integerQueue.add(2);

        integerQueueWithComparator.add(1);
        integerQueue.add(1);

        assertThat(integerQueue.poll())
                .isEqualTo(1)
                .isEqualTo(integerQueueWithComparator.poll());

        assertThat(integerQueue.poll())
                .isEqualTo(2)
                .isEqualTo(integerQueueWithComparator.poll());

        assertThat(integerQueue.poll())
                .isEqualTo(3)
                .isEqualTo(integerQueueWithComparator.poll());

    }
}
