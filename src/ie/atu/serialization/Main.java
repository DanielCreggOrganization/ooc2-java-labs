package ie.atu.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Serializable {

	public static void main(String[] args) {
		// Create Person object
		Person personObject1 = new Person("John", 25);
		System.out.println("Person object to serialize: " + personObject1.getName() + ", " + personObject1.getAge());
	
		// Required for serialization
		FileOutputStream outputByteFileStream = null;
		ObjectOutputStream outputByteFileStreamForObjects = null;
		// Required for de-serialization
		FileInputStream inputByteFileStream = null;
		ObjectInputStream inputByteFileStreamForObjects = null;
		
		try {
			// Serialization
			// Create a byte stream connected to an output file
			outputByteFileStream = new FileOutputStream("./resources/personByteFile.ser");
			// Upgrade the byte stream to accommodate the streaming of Objects
			outputByteFileStreamForObjects = new ObjectOutputStream(outputByteFileStream);
			// Commence the serialization of the object
			outputByteFileStreamForObjects.writeObject(personObject1);
			System.out.println("Object has been serialized");
			
			// De-Serialization
			// Create a byte stream connected to an input file
			inputByteFileStream = new FileInputStream("./resources/personByteFile.ser");
			// Upgrade the byte stream to accommodate the streaming of Objects
			inputByteFileStreamForObjects = new ObjectInputStream(inputByteFileStream);
			// Commence the de-serialization of the object and store it in a new object
			Person personObject2 = (Person) inputByteFileStreamForObjects.readObject();
			System.out.println("Object has been de-serialized");
			
			System.out.println("Person object de-serialized: " + personObject2.getName() + ", " + personObject2.getAge());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Exception was caught");
			e.printStackTrace();
		} // End try/catch

	} // End main
} // End Class
