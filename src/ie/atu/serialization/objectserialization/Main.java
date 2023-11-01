//This example is used to test the serialization and de-serialization of objects.
package ie.atu.serialization.objectserialization;

import java.io.FileInputStream; // Used to read from a file
import java.io.FileOutputStream; // Used to write to a file
import java.io.ObjectInputStream; // Used to read objects from a file
import java.io.ObjectOutputStream; // Used to write objects to a file

public class Main {
	public static void main(String[] args) {
		// Serialize and De-Serialize an employee object.

		// Create employee object. This employee object that will be serialized (i.e.
		// converted to bytes and stored in a file)
		Employee employeeObject1 = new Employee("827384773H", "Collins");
		System.out.println(employeeObject1.toString()); // Print employee object

		// Create file streams. These are used to read and write bytes to a file.
		FileOutputStream outputByteFileStream = null; // Used to write bytes to a file
		FileInputStream inputByteFileStream = null; // Used to read bytes from a file
		ObjectOutputStream outputByteFileStreamForObjects = null; // Used to write objects to a file
		ObjectInputStream inputByteFileStreamForObjects = null; // Used to read objects from a file

		// SERIALIZATION
		try {
			// Create a file output stream. This is used to write bytes to a file.
			outputByteFileStream = new FileOutputStream("./resources/employee.ser");
			// Upgrade file output stream to object output stream
			outputByteFileStreamForObjects = new ObjectOutputStream(outputByteFileStream);
			// Serialize Employee object and stream to file for storage
			outputByteFileStreamForObjects.writeObject(employeeObject1);
			System.out.println("Employee object has been serialized!");
		} catch (Exception ex) { // Catch all exceptions
			ex.printStackTrace(); // Print exception details
		} finally { // Finally block is always executed
			// Close file streams
			try {
				outputByteFileStream.close();
				outputByteFileStreamForObjects.close();
			} catch (Exception ex) { // Catch all exceptions
				ex.printStackTrace(); // Print exception details
			}
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
		} catch (Exception ex) { // Catch all exceptions
			ex.printStackTrace(); // Print exception details
		} finally { // Finally block is always executed
			// Close file streams
			try {
				inputByteFileStream.close();
				inputByteFileStreamForObjects.close();
			} catch (Exception ex) { // Catch all exceptions
				ex.printStackTrace(); // Print exception details
			}
		}

	} // End main method
} // End Main class
