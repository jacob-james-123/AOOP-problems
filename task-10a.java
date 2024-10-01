package tasks.task10;
import java.util.LinkedList;
import java.util.Queue;
public class t1 {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); // Buffer with capacity of 5

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
// Shared buffer class using a thread-safe queue
class SharedBuffer {
    private final Queue<String> queue = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    // Method to add a message to the buffer
    public synchronized void put(String message) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait until there's space in the queue
        }
        queue.offer(message);
        System.out.println("Produced: " + message);
        notifyAll(); // Notify consumers that a new message is available
    }

    // Method to consume a message from the buffer
    public synchronized String take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait until there's a message to consume
        }
        String message = queue.poll();
        notifyAll(); // Notify producers that space is available
        return message;
    }
}

// Producer class
class Producer implements Runnable {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                String message = "Message " + i;
                buffer.put(message);
                Thread.sleep(500); // Simulate time taken to produce a message
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Consumer class
class Consumer implements Runnable {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                String message = buffer.take();
                System.out.println("Consumed: " + message);
                Thread.sleep(1000); // Simulate time taken to consume a message
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Main class to run the producer-consumer application
