package ie.atu.args;

public class MethodArgs {
	
	public static void main(String[] args) {
		
		// Call the add method. Pass two integers as arguments to this method.
		add(5, 6); 
				
	} // End main

	// add method with two input parameters, one integer named x and one named y.
	static void add(int x, int y) {
		System.out.println("Argument 1: " + x);
		System.out.println("Argument 2: " + y);
		System.out.println("Argument 1 + Argument 2 = " + (x + y));
	
	} // End add method
	
} // End class
