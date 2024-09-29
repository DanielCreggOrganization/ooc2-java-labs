package ie.atu.lambda;

import java.util.function.*;

public class InbuiltFunctionalInterfaceExamples {
    public static void main(String[] args) {
        // 1. Predicate Example: Check if a number is even. 
        // A Predicate takes an input of type T and returns a boolean value. It's often used for conditional checks.
        Predicate<Integer> isEven = num -> int i = num % 2 == 0;
                System.out.println("Is 4 even? " + isEven.test(4)); // Output: true
                System.out.println("Is 5 even? " + isEven.test(5)); // Output: false
        
                // 2. Function Example: Get the length of a string.
                // A Function takes an input of type T and produces a result of type R. It's commonly used for transformations.
                Function<String, Integer> stringLength = str -> str.length();
                System.out.println("Length of 'Hello': " + stringLength.apply("Hello")); // Output: 5
        
                // 3. Consumer Example: Print a message
                // A Consumer takes an input of type T and returns no result. It’s typically used for operations that perform actions on the input.
                Consumer<String> print = str -> System.out.println("Consumer prints: " + str);
                print.accept("Hello, World!"); // Output: Consumer prints: Hello, World!
        
                // 4. Supplier Example: Generate a random double value
                // A Supplier does not take any input but returns a result of type T. It’s often used to generate or supply values.
                Supplier<Double> randomValue = () -> Math.random();
                System.out.println("Random value: " + randomValue.get()); // Output: A random double value
        
                // 5. UnaryOperator Example: Square a number
                // A UnaryOperator takes an input of type T and returns a result of the same type T. It’s used when the input and output types are the same.
                UnaryOperator<Integer> square = x -> x * x;
                System.out.println("Square of 5: " + square.apply(5)); // Output: 25
        
                // 6. BinaryOperator Example: Add two integers
                // A BinaryOperator takes two inputs of type T and returns a result of the same type T. It’s used when the input and output types are the same.
                BinaryOperator<Integer> add = (a, b) -> a + b;
                System.out.println("Sum of 3 and 4: " + add.apply(3, 4)); // Output: 7

                // 7. Runnable Example: Run a task
                // A Runnable does not take any input and returns no result. It’s used to define a task that can be run asynchronously.
                Runnable task = () -> System.out.println("Running a task...");
                task.run(); // Output: Running a task...
    }
}