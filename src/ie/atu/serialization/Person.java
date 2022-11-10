package ie.atu.serialization;

// Import Serializable interface
import java.io.Serializable;

// To serialize an object, the class must implement the Serializable interface
public class Person implements Serializable {

    // Instance Variables
    private String name;
    private int age;
    
    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    } // End constructor

} // End of class
