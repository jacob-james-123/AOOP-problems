package tasks.task7;
import java.util.ArrayList;
import java.util.Comparator;

public class t2 {
    
    public static void main(String[] args) {
        // Test with Integer data type (natural ordering)
        PriorityQueue<Integer> intQueue = new PriorityQueue<>();
        intQueue.add(10);
        intQueue.add(5);
        intQueue.add(20);
        intQueue.add(1);
        System.out.println("Integer Priority Queue:");
        intQueue.displayQueue();
        System.out.println("Top element (min): " + intQueue.peek());
        System.out.println("Removed element: " + intQueue.remove());
        intQueue.displayQueue();

        // Test with String data type (natural ordering, alphabetically)
        PriorityQueue<String> stringQueue = new PriorityQueue<>();
        stringQueue.add("Banana");
        stringQueue.add("Apple");
        stringQueue.add("Cherry");
        System.out.println("\nString Priority Queue:");
        stringQueue.displayQueue();
        System.out.println("Top element (min): " + stringQueue.peek());
        System.out.println("Removed element: " + stringQueue.remove());
        stringQueue.displayQueue();

        // Test with Double data type (natural ordering)
        PriorityQueue<Double> doubleQueue = new PriorityQueue<>();
        doubleQueue.add(12.5);
        doubleQueue.add(7.4);
        doubleQueue.add(3.9);
        doubleQueue.add(9.2);
        System.out.println("\nDouble Priority Queue:");
        doubleQueue.displayQueue();
        System.out.println("Top element (min): " + doubleQueue.peek());
        System.out.println("Removed element: " + doubleQueue.remove());
        doubleQueue.displayQueue();
    }
}



// Step 1: Define a generic class for the priority queue
 class PriorityQueue<T> {
    private ArrayList<T> heap;  // Internal data structure to store the heap
    private Comparator<? super T> comparator;  // To compare elements

    // Constructor using default comparator (natural ordering)
    public PriorityQueue() {
        this(null);
    }

    // Constructor with a custom comparator
    public PriorityQueue(Comparator<? super T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    // Step 2: Add a new element to the priority queue
    public void add(T item) {
        heap.add(item);         // Add item to the end
        heapifyUp(heap.size() - 1);  // Adjust position to maintain heap order
    }

    // Step 3: Remove the element with the highest priority (min element for min-heap)
    public T remove() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        T result = heap.get(0);            // Get the root (min element)
        T lastItem = heap.remove(heap.size() - 1);  // Remove the last item
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);         // Replace the root with the last item
            heapifyDown(0);                // Adjust position to maintain heap order
        }
        return result;
    }

    // Step 4: Peek at the element with the highest priority without removing it
    public T peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap.get(0);
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Heapify up (restore heap order after insertion)
    private void heapifyUp(int index) {
        T item = heap.get(index);
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T parent = heap.get(parentIndex);
            if (compare(item, parent) >= 0) {
                break;
            }
            heap.set(index, parent);
            index = parentIndex;
        }
        heap.set(index, item);
    }

    // Heapify down (restore heap order after removal)
    private void heapifyDown(int index) {
        int size = heap.size();
        T item = heap.get(index);
        while (index < size / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            int smallerChild = leftChild;
            if (rightChild < size && compare(heap.get(rightChild), heap.get(leftChild)) < 0) {
                smallerChild = rightChild;
            }
            if (compare(heap.get(smallerChild), item) >= 0) {
                break;
            }
            heap.set(index, heap.get(smallerChild));
            index = smallerChild;
        }
        heap.set(index, item);
    }

    // Comparison method to support both natural ordering and custom comparator
    private int compare(T item1, T item2) {
        if (comparator != null) {
            return comparator.compare(item1, item2);
        } else {
            return ((Comparable<T>) item1).compareTo(item2);
        }
    }

    // Display elements for debugging
    public void displayQueue() {
        System.out.println(heap);
    }

}