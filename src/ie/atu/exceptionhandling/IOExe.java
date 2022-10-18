package ie.atu.exceptionhandling;

public class IOExe {
	public static void main(String args[]) {

		// Create car object
		Car carObject1 = new Car();
		// Call readInCarDetails method from car class
		carObject1.readInCarDetails();
		
		System.out.println("Reached the end of the program without crashing!");
	} // End main
} // End Class
