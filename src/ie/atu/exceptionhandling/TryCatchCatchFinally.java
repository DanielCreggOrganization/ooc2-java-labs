package ie.atu.exceptionhandling;

public class TryCatchCatchFinally {
    // Demonstrating the try-catch-catch-finally block.
    public static void main(String[] args) {
        //  int used to store things throughout the program.
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
            // Handle the exception. This code will run if an ArithmeticException is thrown.
            System.out.println("An arithmetic error occurred!");
        } catch (Exception e) {
            // Handle the exception.
            System.out.println("An array index out of bounds error occurred!");
        } finally {
            // This code will always run regardless of whether an exception is thrown or not.
            System.out.println("Finally block executed");
            // Resetting reusableInt to 0
            reusableInt = 0;
            System.out.println("reusableInt = " + reusableInt);
            System.out.println("Reusable int reset to 0. Ready to use again in rest of program.");
        }
        // This code will run after the try-catch-finally block.
        System.out.println("Program continues to run after try-catch-finally block.");
    } // end of main method
}
