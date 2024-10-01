package tasks.task7;

public class t1 {
    // Step 4: Main class to test the stack implementations

    public static void main(String[] args) {
        // Testing LinkedListStack with Integer
        Stack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(10);
        linkedListStack.push(20);
        linkedListStack.push(30);
        System.out.println("LinkedListStack (Integer) - Top Element: " + linkedListStack.peek());
        System.out.println("LinkedListStack (Integer) - Popped Element: " + linkedListStack.pop());
        System.out.println("LinkedListStack (Integer) - Is Empty: " + linkedListStack.isEmpty());

        // Testing ArrayStack with String
        Stack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("Apple");
        arrayStack.push("Banana");
        arrayStack.push("Cherry");
        System.out.println("\nArrayStack (String) - Top Element: " + arrayStack.peek());
        System.out.println("ArrayStack (String) - Popped Element: " + arrayStack.pop());
        System.out.println("ArrayStack (String) - Is Empty: " + arrayStack.isEmpty());

        // Testing LinkedListStack with Character
        Stack<Character> charLinkedListStack = new LinkedListStack<>();
        charLinkedListStack.push('A');
        charLinkedListStack.push('B');
        charLinkedListStack.push('C');
        System.out.println("\nLinkedListStack (Character) - Top Element: " + charLinkedListStack.peek());
        System.out.println("LinkedListStack (Character) - Popped Element: " + charLinkedListStack.pop());
    }
}


// Step 1: Define a generic interface for the Stack
interface Stack<T> {
    void push(T item);   // Adds an item to the stack
    T pop();             // Removes and returns the item at the top of the stack
    T peek();            // Returns the item at the top of the stack without removing it
    boolean isEmpty();   // Checks if the stack is empty
}

// Step 2: Implement the Stack using a LinkedList
class LinkedListStack<T> implements Stack<T> {
    // Internal Node class for linked list representation
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node top; // Reference to the top of the stack

    @Override
    public void push(T item) {
        Node newNode = new Node(item);
        newNode.next = top; // Link the new node to the top
        top = newNode;      // Update top reference
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = top.data;  // Get the data from the top node
        top = top.next;     // Remove the top node by updating the top reference
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}

// Step 3: Implement the Stack using an Array
class ArrayStack<T> implements Stack<T> {
    private T[] stackArray;  // Array to store stack elements
    private int top;         // Index of the top element
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        stackArray = (T[]) new Object[INITIAL_CAPACITY];
        top = -1; // Stack is empty initially
    }

    @Override
    public void push(T item) {
        if (top == stackArray.length - 1) {
            resize(2 * stackArray.length); // Double the size if the array is full
        }
        stackArray[++top] = item; // Increment top and add item
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = stackArray[top];
        stackArray[top--] = null;  // Remove and dereference the top item
        if (top > 0 && top == stackArray.length / 4) {
            resize(stackArray.length / 2);  // Shrink array size if needed
        }
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackArray[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    // Resize the stack array
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(stackArray, 0, newArray, 0, top + 1);
        stackArray = newArray;
    }
}

