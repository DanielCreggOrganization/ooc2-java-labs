package ie.atu.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Averager {
	public static void main(String[] args) {
		// Instance variables
		File file = null;
		Scanner scannerObject = null;
		List<Integer> listOfInts = null;
		int total = 0;
		int nextInt = 0;

		try {
			file = new File("./resources/results.txt");
			scannerObject = new Scanner(file);
			// Create an array to hold the ints
			listOfInts = new ArrayList<Integer>();

			// Loop over ints in file
			while (scannerObject.hasNextInt()) {
				nextInt = scannerObject.nextInt();
				listOfInts.add(nextInt);
				total += nextInt;
			}

			System.out.println("Inputted ints:" + listOfInts.toString());
			System.out.println("Total results in file: " + listOfInts.size());
			System.out.println("Average of all results: " + (double) total / listOfInts.size());

		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} finally {
			scannerObject.close();
		}
	}
}
