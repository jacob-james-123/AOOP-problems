// Generic stack interface with common stack operations
interface Stack<T> {
    void push(T element);    // Add an element to the stack
    T pop();                 // Remove and return the top element from the stack
    T peek();                // Return the top element without removing it
    boolean isEmpty();       // Check if the stack is empty
}

// Implementation of Stack using Linked List
class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;     // Top of the stack

    // Node class for linked list implementation
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    // Push an element onto the stack
    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
    }

    // Pop an element from the stack
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    // Peek the top element of the stack
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // Check if the stack is empty
    @Override
    public boolean isEmpty() {
        return top == null;
    }
}

// Implementation of Stack using an Array
class ArrayStack<T> implements Stack<T> {
    private T[] array;
    private int top;

    // Constructor to initialize the array stack with a default capacity
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
        top = -1;
    }

    // Push an element onto the stack
    @Override
    public void push(T element) {
        if (top == array.length - 1) {
            throw new RuntimeException("Stack is full");
        }
        array[++top] = element;
    }

    // Pop an element from the stack
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top--];
    }

    // Peek the top element of the stack
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    // Check if the stack is empty
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}

// Testing the Stack Implementations with Different Data Types
public class Stack_generic_7a {
    public static void main(String[] args) {
        // Test with LinkedListStack
        Stack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        System.out.println("LinkedListStack (Integer):");
        System.out.println("Top Element: " + linkedListStack.peek());
        System.out.println("Popped Element: " + linkedListStack.pop());
        System.out.println("Is Empty: " + linkedListStack.isEmpty());

        // Test with ArrayStack
        Stack<String> arrayStack = new ArrayStack<>(5);
        arrayStack.push("Hello");
        arrayStack.push("World");
        System.out.println("\nArrayStack (String):");
        System.out.println("Top Element: " + arrayStack.peek());
        System.out.println("Popped Element: " + arrayStack.pop());
        System.out.println("Is Empty: " + arrayStack.isEmpty());

        // Further testing with different data types
        Stack<Character> charStack = new LinkedListStack<>();
        charStack.push('A');
        charStack.push('B');
        System.out.println("\nLinkedListStack (Character):");
        System.out.println("Top Element: " + charStack.peek());
        System.out.println("Popped Element: " + charStack.pop());
        System.out.println("Is Empty: " + charStack.isEmpty());

        Stack<Float> floatStack = new ArrayStack<>(3);
        floatStack.push(1.1f);
        floatStack.push(2.2f);
        floatStack.push(3.3f);
        System.out.println("\nArrayStack (Float):");
        System.out.println("Top Element: " + floatStack.peek());
        System.out.println("Popped Element: " + floatStack.pop());
        System.out.println("Is Empty: " + floatStack.isEmpty());
    }
}
