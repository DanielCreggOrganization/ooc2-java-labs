//Java code for deserialization of a Car object 
package ie.atu.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializeCar {
	public static void main(String[] args) {

		// Car deserializedCarObject = null; // Car Object to store deserialized Car
		// Object
		List<Car> deserializedCarList = new ArrayList<Car>();

		// Object Streams out of storage file
		FileInputStream fileInStream = null;
		ObjectInputStream objectInStream = null;

		// Create a String to hold the object storage file name
		String objectStorageFileName = ".\\resources\\objectStorageFile.ser";

		try {
			// Create input object stream from file
			fileInStream = new FileInputStream(objectStorageFileName);
			objectInStream = new ObjectInputStream(fileInStream);

			// Deserialization of object and storage to empty Car object
			// deserializedCarObject = (Car) objectInStream.readObject();

			deserializedCarList = (ArrayList<Car>) objectInStream.readObject();

			System.out.println("Car object/s have been deserialized from " + objectStorageFileName);
			// System.out.println("Deserialized Car Make = " +
			// deserializedCarObject.getMake());
			// System.out.println("Deserialized Car Age = " +
			// deserializedCarObject.getAge());
//			System.out.println("Deserialized Car Age = " + deserializedCarObject.owner);
			System.out.println("Deserialized Car Age = " + deserializedCarList.get(0).getMake());
			System.out.println("Deserialized Car Age = " + deserializedCarList.get(0).getAge());
			System.out.println("Deserialized Car Age = " + deserializedCarList.get(1).getMake());
			System.out.println("Deserialized Car Age = " + deserializedCarList.get(1).getAge());

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Close input streams
				fileInStream.close();
				objectInStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
