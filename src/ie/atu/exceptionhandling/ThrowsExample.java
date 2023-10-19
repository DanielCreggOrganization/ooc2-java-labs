package ie.atu.exceptionhandling;

public class ThrowsExample {
    // Create an example to demonstrate the throws clause.
    public static void main(String[] args) {
        // Call throwException method.
        try {
            throwException();
        } catch (Exception e) {
            // Handle the exception.
            System.out.println("An error occurred!");
        } // end of try-catch
    } // end of main method

    // Add a throws clause to the method signature.
    static void throwException() throws Exception {
        // Create exception
        Exception exception = new Exception();
        // Throw exception
        throw exception;
    } // end of throwException method
} // end of class
