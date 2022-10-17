package ie.atu.exceptionhandling;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputMismatch {

	public static void main(String args[]) {
		
		// Create variable to store user input
		int age = 0;
		
		// Ask user what age they are
		System.out.println("Please enter your age: ");
		
		// Create scanner object to capture user input
		Scanner userInput = new Scanner(System.in);
		
		// Try to read in the users age
			try {
				age = userInput.nextInt();
				System.out.println("You are " + age + " years old.");
			} catch (InputMismatchException inputMisEx) {
				System.out.print(inputMisEx);
				System.err.println("\nYou did not enter an integer!\n");
				//System.err.println("\nException in thread: " + inputMisEx + "\n\tat " + inputMisEx.getStackTrace()[inputMisEx.getStackTrace().length - 1]);
			} finally {
				userInput.close(); // Close Scanner object
			}
	 
	    
		System.out.println("The program has ended. Goodbye!");

	} // End main
} // End class
