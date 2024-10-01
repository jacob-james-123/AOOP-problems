package tasks.task6;

public class t2 {
    // Step 4: Main class to test the functionality

    public static void main(String[] args) {

        // Test with Integer array
        Integer[] intArray = {3, 5, 1, 9, 2};
        ArrayProcessor<Integer> intProcessor = new ArrayProcessor<>();
        System.out.println("Integer Array - Max: " + intProcessor.findMax(intArray));
        System.out.println("Integer Array - Min: " + intProcessor.findMin(intArray));

        // Test with String array
        String[] stringArray = {"apple", "banana", "pear", "grape"};
        ArrayProcessor<String> stringProcessor = new ArrayProcessor<>();
        System.out.println("String Array - Max: " + stringProcessor.findMax(stringArray));
        System.out.println("String Array - Min: " + stringProcessor.findMin(stringArray));

        // Test with Character array
        Character[] charArray = {'x', 'a', 'p', 'm', 'r'};
        ArrayProcessor<Character> charProcessor = new ArrayProcessor<>();
        System.out.println("Character Array - Max: " + charProcessor.findMax(charArray));
        System.out.println("Character Array - Min: " + charProcessor.findMin(charArray));

        // Test with Float array
        Float[] floatArray = {2.5f, 3.8f, 1.2f, 9.5f};
        ArrayProcessor<Float> floatProcessor = new ArrayProcessor<>();
        System.out.println("Float Array - Max: " + floatProcessor.findMax(floatArray));
        System.out.println("Float Array - Min: " + floatProcessor.findMin(floatArray));
    }
}

    

// Step 1: Define a generic interface with methods for finding min and max
interface ArrayOperations<T extends Comparable<T>> {
    T findMax(T[] array);
    T findMin(T[] array);
}

// Step 2: Implement the generic class that handles multiple data types
class ArrayProcessor<T extends Comparable<T>> implements ArrayOperations<T> {

    @Override
    public T findMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    @Override
    public T findMin(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        T min = array[0];
        for (T element : array) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }
}

