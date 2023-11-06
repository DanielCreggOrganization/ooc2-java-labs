package ie.atu.streams.lambda;

public class Main {
    public static void main(String[] args) {
        // Create a new cat
        Cat catObject1 = new Cat("Tiddles", 3);
        // 1. Call the print method on the cat
        catObject1.print();
        // 2. Call the printThing method on the cat
        printNoReturn(catObject1);
        // 3. Call the printThing method on a lambda expression
        printNoReturn(() -> System.out.println("Meow"));
        // 4. Create printable
        PrintableNoReturn lambdaPrintableNoReturn = () -> System.out.println("Meow");
        printNoReturn(lambdaPrintableNoReturn);
        // 5. Create printable
        PrintableWithParameters lambdaPrintableWithParameters = (p, s) -> System.out.println(p + "Meow" + s);
        printWithParameters(lambdaPrintableWithParameters);
        // 6. Create printable
        PrintableWithReturn lambdaPrintableWithReturn = (s, p) -> s + "Meow" + p;
        //printWithReturn(lambdaPrintableWithReturn);
        // Here we are calling the print method on the lambdaPrintableWithReturn object
        System.out.println(lambdaPrintableWithReturn.print("Hello ", " World"));
        
    }
    
    // This method takes a Printable object and calls its print method
    public static void printNoReturn(PrintableNoReturn thing) {
        thing.print();
    }
    
    // This method takes a Printable object and calls its print method
    public static void printWithParameters(PrintableWithParameters thing) {
        thing.print("Hello ", " World");
    }
    
    // This method takes a Printable object and calls its print method
    public static void printWithReturn(PrintableWithReturn thing) {
        System.out.println(thing.print("Hello ", " World"));
    }

}
