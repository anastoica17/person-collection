package concurrent;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;


/**
 * * The Future class represents a future result of an asynchronous computation.
 * * This result will eventually appear in the Future after the processing is complete.
 */
class CompletableFutureTest {

    @Test
    void whenUsingNonAsync_thenMainThreadIsUsed() throws Exception {
        CompletableFuture<String> name = CompletableFuture.supplyAsync(() -> "Baeldung");

        CompletableFuture<Integer> nameLength = name.thenApply(value -> {
            printCurrentThread(); // will print "main"
            return value.length();
        });

        assertThat(nameLength.get()).isEqualTo(8);
    }

    @Test
    void whenUsingNonAsync_thenUsesCallersThread() throws Exception {
        Runnable test = () -> {
            CompletableFuture<String> name = CompletableFuture.supplyAsync(() -> "Baeldung");

            CompletableFuture<Integer> nameLength = name.thenApply(value -> {
                printCurrentThread(); // will print "test-thread"
                return value.length();
            });

            try {
                assertThat(nameLength.get()).isEqualTo(8);
            } catch (Exception e) {
                fail(e.getMessage());
            }
        };

        new Thread(test, "test-thread").start();
        Thread.sleep(100l);
    }

    @Test
    void whenUsingAsync_thenUsesCommonPool() throws Exception {
        CompletableFuture<String> name = CompletableFuture.supplyAsync(() -> "Baeldung");

        CompletableFuture<Integer> nameLength = name.thenApplyAsync(value -> {
            printCurrentThread(); // will print "ForkJoinPool.commonPool-worker-1"
            return value.length();
        });

        assertThat(nameLength.get()).isEqualTo(8);
    }

    @Test
    void whenUsingAsync_thenUsesCustomExecutor() throws Exception {
        Executor testExecutor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> name = CompletableFuture.supplyAsync(() -> "Baeldung");

        CompletableFuture<Integer> nameLength = name.thenApplyAsync(value -> {
            printCurrentThread(); // will print "pool-2-thread-1"
            return value.length();
        }, testExecutor);

        assertThat(nameLength.get()).isEqualTo(8);
    }

    @Test
    void completedFutureExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        assertTrue(cf.isDone());
        assertEquals("message", cf.getNow(null));
    }


    @Test
    void thenApplyExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            assertFalse(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        assertEquals("MESSAGE", cf.getNow(null));
    }

    private static void printCurrentThread() {
        System.out.println(Thread.currentThread().getName());
    }


}
