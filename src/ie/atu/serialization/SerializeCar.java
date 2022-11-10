//Java code for serialization of a Car object 
package ie.atu.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeCar {
	public static void main(String[] args) {

		Car carObject1 = null; // Car Object to serialize
		Car carObject2 = null; // Car Object to serialize
		List<Car> cars = null;

		// Object Streams out and into storage file
		FileOutputStream fileOutStream = null;
		ObjectOutputStream objectOutStream = null;
		// Create a String to hold the object storage file name
		String objectStorageFileName = ".\\resources\\objectStorageFile.ser";

		// Create a Car object to be serialized
		carObject1 = new Car("Ford", 1);
		carObject2 = new Car("Nissan", 2);

		cars = new ArrayList<Car>(); // Create ArrayList to store car objects
		cars.add(carObject1); // Add car object 1
		cars.add(carObject2); // Add car object 2

		try {
			// Set up object stream to file
			fileOutStream = new FileOutputStream(objectStorageFileName);
			objectOutStream = new ObjectOutputStream(fileOutStream);
			// Serialize Car object and stream to file for storage
			// objectOutStream.writeObject(carObject1);
			// objectOutStream.writeObject(carObject2);
			objectOutStream.writeObject(cars);

			System.out.println("The Car object/s have been serialized!");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// Close output streams
			try {
				objectOutStream.close();
				fileOutStream.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
