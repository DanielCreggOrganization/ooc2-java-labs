package ie.atu.lambda;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // StringOperation toUpper = new ToUpperCase();
        // System.out.println(toUpper.apply("hello lambda")); // Expected Output: "HELLO
        // LAMBDA"

        StringOperation toUpper = str -> str.toUpperCase();
        System.out.println(toUpper.apply("hello lambda")); // Expected Output: "HELLO LAMBDA"

        Runnable task = () -> System.out.println("Hello from the thread");
        Thread thread = new Thread(task);
        thread.start();

        Calculator square = x -> x * x;
        int result1 = square.calculate(5);
        System.out.println("Square of 5 is: " + result1); // Expected Output: "Square of 5 is: 25"

        Function<String, String> trim = s -> s.trim();
        Function<String, String> replaceSpaces = s -> s.replace(" ", "-");
        Function<String, String> toLowerCase = s -> s.toLowerCase();
        Function<String, String> combinedOperation = trim.andThen(replaceSpaces).andThen(toLowerCase);

        String result2 = combinedOperation.apply("   Hello World From Lambda   ");
        System.out.println("Result: " + result2); // Expected Output: "hello-world-from-lambda"
    }
}
