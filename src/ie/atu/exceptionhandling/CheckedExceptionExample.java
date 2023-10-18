package ie.atu.exceptionhandling;

import java.io.File;
import java.io.IOException; // Import the IOException class

public class CheckedExceptionExample {

    public static void main(String[] args) {
        // Create a new File object.
        File file = new File("/path/to/file.txt");

        // Add a try-catch block to handle the FileNotFoundException.
        try {
            // This code may throw a FileNotFoundException, which is a checked exception.
            // Therefore, we must either handle the exception or declare it in the throws
            // clause.
            file.createNewFile();
        } catch (IOException e) {
            // Handle the FileNotFoundException
            System.out.println("File not found!");
        }
    }
}
