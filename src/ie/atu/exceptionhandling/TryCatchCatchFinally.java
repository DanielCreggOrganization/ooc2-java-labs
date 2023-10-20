package ie.atu.exceptionhandling;

public class TryCatchCatchFinally {
    // Demonstrating the try-catch-cathch-finally block.
    public static void main(String[] args) {
        // int i will use to store things throughout the program.
        int reusableInt = 0;
        // Call method1.
        try {
            // Setting the value of reusableInt to 10 for demonstration purposes.
            reusableInt = 10;
            System.out.println("reusableInt = " + reusableInt);
            // ArithmeticException is thrown if you divide by zero.
            int i = 10 /0;
            System.out.println("i = " + i);
            // int Array of length 5 created.
            int[] array = new int[5];
            // ArrayIndexOutOfBoundsException is thrown if you try to access an index >= 5.
            array[10] = 42;
        } catch (ArithmeticException e) {
            // Handle the exception.
            System.out.println("An arithmetic error occurred!");
        } catch (Exception e) {
            // Handle the exception.
            System.out.println("An array index out of bounds error occurred!");
        } finally {
            // This code will always run.
            System.out.println("Finally block executed");
            // Resetting reusableInt to 0
            reusableInt = 0;
            System.out.println("reusableInt = " + reusableInt);
            System.out.println("Reusable int reset to 0. Ready to use again in rest of program.");
        } // end of try-catch-finally
        // This code will run after the try-catch-finally block.
        System.out.println("Program continues to run after try-catch-finally block.");
    } // end of main method
}
