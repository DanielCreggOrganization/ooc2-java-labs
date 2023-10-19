package ie.atu.exceptionhandling;

public class ThrowsExample {
    // Create an example to demonstrate the throws clause.
    public static void main(String[] args) {
        // Create a new ThrowsExample object.
        ThrowsExample throwsExample = new ThrowsExample();
    try {
        // Call the method that throws an exception.
        throwsExample.throwException();
    } catch (Exception e) {
        // Handle the exception.
        System.out.println("An error occurred!");
    }

    // Add a throws clause to the method signature.
    public void throwException() throws Exception {
        // Create exception
        Exception exception = new Exception();
        // Throw exception
        throw exception;
    }
}
