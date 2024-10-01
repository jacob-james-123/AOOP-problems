package tasks.task8;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class t2 {
        public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Stream pipeline to filter, double, and collect the results into a new list
        List<Integer> doubledEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)  // Filter to get only even numbers
                .map(n -> n * 2)          // Double the even numbers
                .collect(Collectors.toList());  // Collect into a list

        // Display the result
        System.out.println("Doubled Even Numbers: " + doubledEvenNumbers);
    }
}


