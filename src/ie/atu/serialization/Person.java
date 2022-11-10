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
        this.setName(name);
        this.setAge(age);
    } // End constructor

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

} // End of class
