package ie.atu.serialization;

import java.io.Serializable;

class Employee implements Serializable {
	/*
	 * Used during deserialization to verify that the sender and receiver of a
	 * serialized object have loaded classes for that object that are compatible
	 * with respect to serialization. If the receiver has loaded a class for the
	 * object that has a different serialVersionUID than that of the corresponding
	 * sender's class, then deserialization will result in an InvalidClassException.
	 */
	private static final long serialVersionUID = 1L;
	public static String COMPANY_NAME = "Intel"; // Is not serialized

	// Instance Variables
	private transient String ppsn; // Is not serialized
	private String surname;

	// Constructor
	public Employee(String ppsn, String surname) {
		this.ppsn = ppsn;
		this.surname = surname;
	}

	// Getters and Setters
	public String getPpsn() {
		return ppsn;
	}

	public void setPpsn(String ppsn) {
		this.ppsn = ppsn;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "PPSN: " + this.getPpsn() + ", Surname: " + this.getSurname() + ", Company: " + COMPANY_NAME;
	}
}
