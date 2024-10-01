package tasks.task10;
import java.util.LinkedList;
import java.util.Queue;

public class t2 // Main class to run the bounded buffer application
 {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer(10); // Buffer with a capacity of 10

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
// Bounded buffer class using a thread-safe queue
class BoundedBuffer {
    private final Queue<String> buffer;
    private final int capacity;

    public BoundedBuffer(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
    }

    // Method to add an item to the buffer
    public synchronized void put(String item) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); // Wait until there's space in the buffer
        }
        buffer.offer(item);
        System.out.println("Produced: " + item);
        notifyAll(); // Notify consumers that a new item is available
    }

    // Method to remove an item from the buffer
    public synchronized String take() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // Wait until there's an item to consume
        }
        String item = buffer.poll();
        notifyAll(); // Notify producers that space is available
        return item;
    }
}

// Producer class
class Producer implements Runnable {
    private final BoundedBuffer buffer;

    public Producer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) { // Producing 20 items
            try {
                String item = "Item " + i;
                buffer.put(item);
                Thread.sleep(300); // Simulate time taken to produce an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
// Consumer class
class Consumer implements Runnable {
    private final BoundedBuffer buffer;

    public Consumer(BoundedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) { // Consuming 20 items
            try {
                String item = buffer.take();
                System.out.println("Consumed: " + item);
                Thread.sleep(500); // Simulate time taken to consume an item
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


