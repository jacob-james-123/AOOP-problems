package AOOP;

import java.util.Arrays;
// Main class to test the PriorityQueue with different data types
public class GenericPriorityQueue_7B {
    public static void main(String[] args) {
        // Test with Integer
        PriorityQueue<Integer> intQueue = new PriorityQueue<>();
        intQueue.enqueue(10);
        intQueue.enqueue(4);
        intQueue.enqueue(15);
        intQueue.enqueue(7);
        System.out.println("Integer Priority Queue:");
        System.out.println("Peek: " + intQueue.peek());
        System.out.println("Dequeue: " + intQueue.dequeue());
        System.out.println("Dequeue: " + intQueue.dequeue());

        // Test with Double
        PriorityQueue<Double> doubleQueue = new PriorityQueue<>();
        doubleQueue.enqueue(5.5);
        doubleQueue.enqueue(2.2);
        doubleQueue.enqueue(9.9);
        doubleQueue.enqueue(1.1);
        System.out.println("\nDouble Priority Queue:");
        System.out.println("Peek: " + doubleQueue.peek());
        System.out.println("Dequeue: " + doubleQueue.dequeue());
        System.out.println("Dequeue: " + doubleQueue.dequeue());

        // Test with String
        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.enqueue("apple");
        stringQueue.enqueue("orange");
        stringQueue.enqueue("banana");
        stringQueue.enqueue("grape");
        System.out.println("\nString Priority Queue:");
        System.out.println("Peek: " + stringQueue.peek());
        System.out.println("Dequeue: " + stringQueue.dequeue());
        System.out.println("Dequeue: " + stringQueue.dequeue());
    }
}



// Generic class for a Priority Queue using a Min-Heap
class PriorityQueue<T extends Comparable<T>> {
    private T[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor to initialize the priority queue with default capacity
    @SuppressWarnings("unchecked")
    public PriorityQueue() {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    // Method to add an element to the priority queue
    public void enqueue(T element) {
        if (size == heap.length) {
            resize();
        }
        heap[size] = element;
        siftUp(size);
        size++;
    }

    // Method to remove and return the highest priority element (min element)
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Priority Queue is empty");
        }
        T min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return min;
    }

    // Method to peek at the highest priority element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Priority Queue is empty");
        }
        return heap[0];
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Resize the heap array when capacity is reached
    private void resize() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    // Helper method to maintain heap order after adding an element (sift up)
    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap[index].compareTo(heap[parentIndex]) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    // Helper method to maintain heap order after removing an element (sift down)
    private void siftDown(int index) {
        while (index < size / 2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallerChildIndex = leftChildIndex;

            if (rightChildIndex < size && heap[rightChildIndex].compareTo(heap[leftChildIndex]) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (heap[index].compareTo(heap[smallerChildIndex]) <= 0) {
                break;
            }
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    // Helper method to swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}


