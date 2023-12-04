package ie.atu.args;

// Import necessary classes for file reading
import java.nio.file.Files; // Used to read the file
import java.nio.file.Paths; // Used to get the path to the file
import java.io.IOException; // Used to handle exceptions

public class ReadInArgFileNIO {
    public static void main(String[] args) {
        // Get the file name from the command line arguments
        // Be sure to add a command line argument when running this program.
        String fileName = args[0];
        // Print the file name to the console
        System.out.println("File name is: " + fileName);
        // Print the file contents
        try {
            // Use the Files.lines method to get a Stream of the lines in the file,
            // then use the forEach method to print each line to the console.
            // The double colon (::) is a method reference, which is a shorthand way 
            // of writing a lambda expression that calls a single method e.g.
            // line -> System.out.println(line))
            Files.lines(Paths.get(fileName)).forEach(System.out::println);
        } catch (IOException e) {
            // If an IOException is thrown (for example, if the file does not exist),
            // print an error message and the stack trace of the exception
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    } // End of method main
} // End of class ReadInFile