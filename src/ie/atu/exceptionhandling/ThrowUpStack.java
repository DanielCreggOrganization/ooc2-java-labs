package ie.atu.exceptionhandling;

public class ThrowUpStack {
    public static void main(String[] args) {
        // The main method is the entry point of the program.
        // Here, we're calling method1 inside a try-catch block.
        // This means that if method1 (or any methods it calls) throws an exception,
        // that exception will be caught and handled here.
        try {
            method1();
        } catch (Exception e) {
            // If an exception is thrown, we print a message and the program continues to run.
            System.out.println("Exception caught in main method");
        }
    }

    public static void method1() throws Exception {
        // method1 calls method2.
        // By declaring that method1 "throws Exception", we're saying that method1 may not handle
        // any exceptions that occur. Instead, those exceptions will be thrown up to the method that called method1 (the main method).
        method2();
    }

    public static void method2() throws Exception {
        // method2 creates an arithmetic exception by dividing by zero.
        // This exception is not caught within method2, so it is thrown up to the method that called method2 which is method1.
        int i = 10/0;
    }
} // end of class


