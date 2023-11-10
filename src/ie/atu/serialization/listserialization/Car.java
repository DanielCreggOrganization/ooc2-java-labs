package ie.atu.serialization.listserialization;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a car with an owner and age.
 */
public class Car implements Serializable {
	// The serialVersionUID is a universal version identifier for a Serializable class.
	// Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object.
	private static final long serialVersionUID = 10L;

	// Instance Variables
	// The owner of the car. This field is transient, so it will not be serialized.
	private transient String owner;
	// The age of the car.
	private int ageOfCar;

	/**
	 * Constructs a new Car with the specified owner and age.
	 *
	 * @param owner the owner of the car
	 * @param ageOfCar the age of the car
	 */
	public Car(String owner, int ageOfCar) {
		this.setOwner(owner);
		this.setAgeOfCar(ageOfCar);
	}

	/**
	 * Returns the owner of the car.
	 *
	 * @return the owner of the car
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the owner of the car.
	 *
	 * @param owner the new owner of the car
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Returns the age of the car.
	 *
	 * @return the age of the car
	 */
	public int getAgeOfCar() {
		return ageOfCar;
	}

	/**
	 * Sets the age of the car.
	 *
	 * @param ageOfCar the new age of the car
	 */
	public void setAgeOfCar(int ageOfCar) {
		this.ageOfCar = ageOfCar;
	}

	@Override
	public String toString() {
		return "Owner: " + Objects.toString(this.getOwner()) + ", Age of Car: " + this.getAgeOfCar();
	}
}