package ie.atu.exceptionhandling;

public class Arithmetic {

	public static void main(String[] args) {
		
		float result = 0;
		
		try {
			// Code that raises exception
			result = 10 / 0;
			System.out.println(result);
		} catch(ArithmeticException artEx) {
			System.out.println(artEx);
			System.out.println("You caused an artihmetic exception!");	
		}
		
		// After exception is thrown the rest of the try block does not get executed
		System.out.println("The program has ended!");
		
	} // End main
} // End class
