package ie.atu.serialization;

import java.io.Serializable;

public class Car implements Serializable {
	/* 
	 * The serialVersionUID is a universal version identifier for a Serializable class.
	 * Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object.
	 */
	private static final long serialVersionUID = -644012276880766677L;
	private transient String owner;
	private String make;
	private int age;

	// Constructors
	public Car(String make, int age) {
		this.make = make;
		this.age = age;
	}

	public Car(String make, int age, String owner) {
		this.make = make;
		this.age = age;
		this.setOwner(owner);
	}

	// Getters and Setters
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
