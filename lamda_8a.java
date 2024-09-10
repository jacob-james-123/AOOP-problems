import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lamda_8a {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("orange");
        strings.add("banana");
        strings.add("grape");

        // Sort the list in descending order using a lambda expression
        strings.sort((s1, s2) -> s2.compareTo(s1));

        // Alternatively, using Collections.sort()
        // Collections.sort(strings, (s1, s2) -> s2.compareTo(s1));

        // Print the sorted list
        System.out.println("Sorted list in descending order: " + strings);
    }
}
