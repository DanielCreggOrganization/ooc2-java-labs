package ie.atu.exceptionhandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Car {
    // Instance variables

    // Constructor

    // Getters and Setters

    // Methods
    @SuppressWarnings("unused")
	public void readInCarDetails() {
        // The program does not compile, because we use FileReader() throws a checked exception, FileNotFoundException.
        try {
			FileReader file = new FileReader("C:\\test\\a.txt");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    } // End readInCarDetails method

} // End Class
