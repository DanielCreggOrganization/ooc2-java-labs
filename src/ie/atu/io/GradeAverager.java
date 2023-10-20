package ie.atu.io;

import java.io.File; // Required to create a File object.
import java.io.FileNotFoundException; // Required for handling FileNotFoundExceptions.
import java.util.List; // Required for List interface.
import java.util.ArrayList; // Required for ArrayList class.
import java.util.Scanner; // Required to read from a file.

public class GradeAverager {
	public static void main(String[] args) {
		// Instance variables
		File file = null; // Required to point to results.txt
		Scanner scannerObject = null; // Required to read from results.txt
		List<Integer> listOfGrades = null; // Required to store grades from results.txt
		int total = 0; // Required to store the total sum of all grades in results.txt
		int nextInt = 0; // Required to store the next int from results.txt

		// Try to read from results.txt
		try {
			// Create a File object to point to results.txt
			file = new File("./resources/grades.txt");
			// Create a Scanner object to read from results.txt
			scannerObject = new Scanner(file);
			// Create an arrayList to hold all the grades from results.txt
			listOfGrades = new ArrayList<Integer>();
			// Loop over grades in file
			while (scannerObject.hasNextInt()) {
				// Read the next int from results.txt
				nextInt = scannerObject.nextInt();
				// Add the next int to the arrayList
				listOfGrades.add(nextInt);
				// Add the next int to the total
				total += nextInt;
			}
			System.out.println("Grades read from file:" + listOfGrades.toString());
			System.out.println("Number of grades read from file: " + listOfGrades.size());
			System.out.println("Average of all grades: " + (double) total / listOfGrades.size() +"%");
		} catch (FileNotFoundException fnf) {
			// Handle the FileNotFoundException
			fnf.printStackTrace();
		} finally {
			// Close the scannerObject
			scannerObject.close();
		}
	}
}
