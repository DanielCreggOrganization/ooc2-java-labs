package ie.atu.args;

class ConvertArgsFormat {
	public static void main(String args[]) {
		// Create three integers
		String arg1String = "";
		String arg2String = "";
		int a = 0; // To store command line argument 1
		int b = 0; // To store command line argument 2
		int result = 0; // Int to hold the result of a + b

		// Check if two or more command line arguments were entered
		if (args.length >= 2) {
			arg1String = args[0];
			arg2String = args[1];
			
			System.out.println("1st argument:\t" + arg1String);
			System.out.println("2nd argument:\t" + arg2String);

			// Check if command line arguments can be converted to integers
			try {
				// Convert the first two command line arguments to integers
				a = Integer.parseInt(arg1String);
				b = Integer.parseInt(arg2String);
				// Store the sum of the command line arguments
				result = a + b;
				System.out.println(a + " + " + b + " = " + result);			
			} catch (NumberFormatException e) {
				System.out.println("You did not enter integers!");
				System.out.println("Please try again. Enter 2 integers as command line arguments.\n");
			} // End try/catch	
				
		} else {	
			System.out.println("Please try again. Enter 2 integers as command line arguments.");
		} // End if
	} // End main
}// End class
