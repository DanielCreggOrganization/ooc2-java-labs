package ie.atu.io;

import java.io.File;
import java.util.Scanner;
import java.util.Formatter;
import java.io.IOException;

public class FileIOTest { // saved as "FileIOTest.java"
	public static void main(String[] args) throws IOException {
		File inputFile = new File("./resources/in.txt");
		File outputFile = new File("./resources/out.txt");
		Scanner inputScanner = new Scanner(inputFile);
		Formatter outputFormatted = new Formatter(outputFile);
		
		int firstInt = inputScanner.nextInt();
		int secondInt = inputScanner.nextInt();
		// format() has the same syntax as printf()
		outputFormatted.format("%d\n", firstInt + secondInt); 
		
		System.out.println("Output has been formatted and sent to output.txt");

		inputScanner.close(); // Close the scanner object
		outputFormatted.close(); // flush the output and close the output file
	}
}