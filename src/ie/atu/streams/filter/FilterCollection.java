package ie.atu.streams.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterCollection {
    public static void main(String[] args) {
        // Create an ArrayList
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Filter the ArrayList using a stream to get only the even numbers. Use the filter() method to 
        // filter the streamand the collect() method to collect the filtered stream into a list.
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0) // Filter the numbers to get only the even numbers
            .collect(Collectors.toList()); // Collect the even numbers into a list

        // Print the even numbers
        System.out.println(evenNumbers);

        // Use the stream to add one to each number in the list. Use the map() method to map each number
        // to a new number and the collect() method to collect the mapped stream into a list.
        List<Integer> incrementedNumbers = numbers.stream()
            .map(n -> n + 1) // Map each number to a new number
            .collect(Collectors.toList()); // Collect the mapped stream into a list
        
        // Print the incremented numbers
        System.out.println(incrementedNumbers);
    }
}
