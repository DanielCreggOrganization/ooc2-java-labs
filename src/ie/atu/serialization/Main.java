package ie.atu.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {	
		System.out.println("Part 1:");
		// PART 1: Serialize and De-Serialize an employee object.

		// Create employee object
		Employee employeeObject1 = new Employee("827384773H", "Collins");
		System.out.println(employeeObject1.toString());

		// Declare required streams for serialization
		FileOutputStream outputByteFileStream = null;
		FileInputStream inputByteFileStream = null;
		ObjectOutputStream outputByteFileStreamForObjects = null;
		ObjectInputStream inputByteFileStreamForObjects = null;

		// SERIALIZATION
		try {
			// Create a file output stream
			outputByteFileStream = new FileOutputStream("./resources/employee.ser");
			// Upgrade file output stream to object output stream
			outputByteFileStreamForObjects = new ObjectOutputStream(outputByteFileStream);
			// Serialize object
			outputByteFileStreamForObjects.writeObject(employeeObject1);
			System.out.println("Employee object has been serialized!");
		} catch (IOException IOExc) {
			IOExc.printStackTrace();
		}

		// DE-SERIALIZATION
		try {
			// Create a file input stream
			inputByteFileStream = new FileInputStream("./resources/employee.ser");
			// Upgrade file input stream to object input stream
			inputByteFileStreamForObjects = new ObjectInputStream(inputByteFileStream);
			// De-Serialize object
			Employee employeeObject2 = (Employee) inputByteFileStreamForObjects.readObject();
			System.out.println("Employee object has been deserialized");
			System.out.println(employeeObject2.toString());
		} catch (IOException IOExc) {
			IOExc.printStackTrace();
		} catch (ClassNotFoundException CNFExc) {
			CNFExc.printStackTrace();
		}

		System.out.println("\nPart 2:");
		// PART 2: Serialize and De-Serialize a list of object. A list itself is an
		// object.

		// Create list of Cars
		List<Car> carList1 = new ArrayList<>();

		// Create 2 Car objects to be serialized
		Car carObject1 = new Car("John F. Kennedy", 3);
		Car carObject2 = new Car("Micheal D. Higgins", 5);

		// Add car objects to list
		carList1.add(carObject1);
		carList1.add(carObject2);
		System.out.println(carList1);

		// Serialize List of Cars
		try {
			// Set up object stream to file
			outputByteFileStream = new FileOutputStream("./resources/cars.ser");
			outputByteFileStreamForObjects = new ObjectOutputStream(outputByteFileStream);
			// Serialize Car object and stream to file for storage
			// objectOutStream.writeObject(carObject1);
			// objectOutStream.writeObject(carObject2);
			outputByteFileStreamForObjects.writeObject(carList1);
		} catch (IOException IOExc) {
			IOExc.printStackTrace();
		}

		// De-Serialize List of Cars
		try {
			// Create a file input stream
			inputByteFileStream = new FileInputStream("./resources/cars.ser");
			// Upgrade file input stream to object input stream
			inputByteFileStreamForObjects = new ObjectInputStream(inputByteFileStream);
			// De-Serialize object
			List<Car> carList2 = (ArrayList<Car>) inputByteFileStreamForObjects.readObject();
			System.out.println("Car list object has been deserialized");
			System.out.println(carList2.toString());
		} catch (IOException IOExc) {
			IOExc.printStackTrace();
		} catch (ClassNotFoundException CNFExc) {
			CNFExc.printStackTrace();
		}
	} // End main method
} // End Main class
