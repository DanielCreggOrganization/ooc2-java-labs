package ie.atu.serialization.objectserialization;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an employee in a company.
 */
class Employee implements Serializable {
	// The serialVersionUID is used during deserialization to verify that the sender
	// and receiver of a serialized object have loaded classes for that object that
	// are compatible with respect to serialization.
	private static final long serialVersionUID = 1L;
	public static final String COMPANY_NAME = "Intel"; // Is not serialized
	
	// Instance variables
	private transient String ppsn; // Is not serialized
	private String surname;

	//Constructs a new Employee with the specified PPSN and surname.
	public Employee(String ppsn, String surname) {
		this.ppsn = ppsn;
		this.surname = surname;
	}

	// Getters and setters
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

	// Override the toString() method to returns a string representation of this Employee.
	@Override
	public String toString() {
		return "PPSN: " + Objects.toString(this.getPpsn()) + ", Surname: " + Objects.toString(this.getSurname())
				+ ", Company: " + COMPANY_NAME;
	}
}