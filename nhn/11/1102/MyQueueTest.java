//1102(목) -> MyLinkedList을 이용해서 Queue와 Test 구현
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class MyQueueTest {

    @BeforeEach
    void setUp() {
        
    }

    @Test
    void element() {
        IQueue<Integer> queue = new MyQueue<>();
        queue.add(3);

        assertAll(
            () -> assertNotNull(queue),
            () -> assertEquals(3, queue.element())
        );

    }

    @Test
    void offer() {
        IQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.poll();
        assertEquals(null, queue.poll());

    }

    @Test
    void poll() {
        IQueue<Integer> queue = new MyQueue<>();
        queue.add(1);

        assertAll(
            () -> assertNotNull(queue),
            () -> assertEquals(1, queue.poll())
        );
    }

    @Test
    void peek() {
        IQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        assertEquals(1, queue.peek());
    }
}