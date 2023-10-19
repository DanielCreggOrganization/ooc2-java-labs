package ie.atu.exceptionhandling;

import java.util.Scanner;

public class FinallyExample {
    // Create an example to demonstrate the finally block using the Scanner class.
    public static void main(String[] args) {
        // Create a new Scanner object.
        Scanner scanner = new Scanner(System.in);

        // Add a try-finally block to close the Scanner object.
        try {
            // This code may throw an exception.
            System.out.println("Enter a number to cause no error or a letter to cause an error: ");
            int number = scanner.nextInt();
            System.out.println("You entered: " + number);
        } catch (Exception e) {
            // Handle the exception.
            System.out.println("An error occurred!");
        } finally {
            // This code will always execute regardless of whether an exception is thrown or not.
            System.out.println("Closing the Scanner object.");
            // Close the Scanner object.
            scanner.close();
        }
    }
}
