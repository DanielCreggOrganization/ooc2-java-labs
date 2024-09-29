package ie.atu.lambda;

public class LambdaExample {
    public static void main(String[] args) {
        // Define two numbers
        int a = 5;
        int b = 3;

        // Call the 'operate' method with different lambda expressions
        System.out.println("Sum: " + operate(a, b, (x, y) -> x + y)); // Sum: 8
        System.out.println("Difference: " + operate(a, b, (x, y) -> x - y)); // Difference: 2
        System.out.println("Product: " + operate(a, b, (x, y) -> x * y)); // Product: 15
    }

    // Method that accepts two integers and a lambda defining the operation
    public static int operate(int a, int b, MathOperation operation) {
        return operation.operate(a, b);
    }

    // Functional interface for defining an operation on two integers
    interface MathOperation {
        int operate(int a, int b);
    }
}