package ie.atu.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Serializable {

	public static void main(String[] args) {
		// Create Person object
		Person personObject1 = new Person("John", 25);
	
		FileOutputStream outputByteFileStream = null;
		ObjectOutputStream outputByteFileStreamForObjects = null;

		// Serialization
		try {
			// Create a byte stream connected to an output file
			outputByteFileStream = new FileOutputStream("./resources/personByteFile.ser");
			// Upgrade the byte stream to accommodate the streaming of Objects
			outputByteFileStreamForObjects = new ObjectOutputStream(outputByteFileStream);
			// Commence the serialization of the object
			outputByteFileStreamForObjects.writeObject(personObject1);
			System.out.println("Object has been serialized");
		} catch (IOException ioExc) {
			System.out.println("IOException was caught");
			ioExc.printStackTrace();
		} // End try/catch

	} // End main
} // End Class
