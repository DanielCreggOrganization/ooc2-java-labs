package ie.atu.streams.lambda;

public class Cat implements PrintableNoReturn {

    // Instance variables
    private String name;
    private int age;

    // Constructor
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Implement the print method from the PrintableNoReturn interface
    public void print() {
        System.out.println("Meow");
    }
}