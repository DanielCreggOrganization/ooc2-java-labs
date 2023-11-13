package ie.atu.serialization.listserialization;

import java.io.Serializable; // Required to implement Serializable

public class Car implements Serializable {
	// The serialVersionUID is a universal version identifier for a Serializable class.
	// Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object.
	private static final long serialVersionUID = 10L;

	// Instance Variables
	private transient String owner; // This field is transient, so it will not be serialized.
	private int ageOfCar; // The age of the car.

	// Constructs a new Car with the specified owner and age.
	public Car(String owner, int ageOfCar) {
		this.owner = owner;
		this.ageOfCar = ageOfCar;
	}

	// Returns the owner of the car.
	public String getOwner() {
		return owner;
	}

	// Sets the owner of the car.
	public void setOwner(String owner) {
		this.owner = owner;
	}

	// Returns the age of the car.
	public int getAgeOfCar() {
		return ageOfCar;
	}

	// Sets the age of the car.
	public void setAgeOfCar(int ageOfCar) {
		this.ageOfCar = ageOfCar;
	}

	// Override the toString() method to returns a string representation of this Car.
	@Override
	public String toString() {
		return "Owner: " + this.getOwner() + ", Age of Car: " + this.getAgeOfCar();
	}
}