
/**
 * Demonstrates the use of try-with-resources block to read a file using BufferedReader.
 * The try-with-resources block automatically closes the resources declared in the try block.
 */
package ie.atu.exceptionhandling;

import java.io.BufferedReader; // Userd to read a file line by line.
import java.io.FileReader; // Used to read a file.
import java.io.IOException; // Used to handle IO exceptions.

public class TryWithResources {
    public static void main(String[] args) {
        // Try-with-resources block to read a file. The resources declared in the try block
        // will be closed automatically.
        try (BufferedReader br = new BufferedReader(new FileReader("./resources/inputHamlet.txt"))) {
            String line; // Used to store the line read from the file.
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}