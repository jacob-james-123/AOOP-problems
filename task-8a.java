package tasks.task8;
import java.util.ArrayList;
import java.util.List;

public class t1 {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> words = new ArrayList<>();
        words.add("Apple");
        words.add("Orange");
        words.add("Banana");
        words.add("Mango");

        // Sort the list in descending order using a lambda expression
        words.sort((str1, str2) -> str2.compareTo(str1));

        // Display the sorted list
        System.out.println("Sorted List in Descending Order: " + words);
    }
}
