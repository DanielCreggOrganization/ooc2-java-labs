package ie.atu.lambda;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Running");
        r.run(); // This will execute the lambda expression
    }
}
