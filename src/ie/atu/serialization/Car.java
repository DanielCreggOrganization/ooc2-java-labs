package ie.atu.serialization;

import java.io.Serializable;

public class Car implements Serializable {
	/*
	 * The serialVersionUID is a universal version identifier for a Serializable
	 * class. Deserialization uses this number to ensure that a loaded class
	 * corresponds exactly to a serialized object.
	 */
	private static final long serialVersionUID = 10L;

	// Instance Variables
	private transient String owner;
	private int ageOfCar;

	// Constructor
	public Car(String owner, int ageOfCar) {
		this.ageOfCar = ageOfCar;
		this.setOwner(owner);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getAgeOfCar() {
		return ageOfCar;
	}

	public void setAgeOfCar(int ageOfCar) {
		this.ageOfCar = ageOfCar;
	}
	
	@Override
	public String toString(){
		return "Owner: " + this.getOwner() +", Age of Car: " + this.getAgeOfCar();
		
	}
}
