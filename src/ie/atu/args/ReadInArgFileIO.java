package ie.atu.args;

// Import necessary classes for file reading
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadInArgFileIO {
    public static void main(String[] args) {
        // Get the file name from the command line arguments
        // Be sure to add a command line argument when running this program
        String fileName = args[0];
        // Print the file name to the console
        System.out.println("File name is: " + fileName);
        // Print the file contents
        try {
            // Create a BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            // Read and print each line in the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // Close the reader
            reader.close();
        } catch (IOException e) {
            // If an IOException is thrown (for example, if the file does not exist),
            // print an error message and the stack trace of the exception
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } // End of try/catch block        
    } // End of method main
} // End of class ReadInFile
