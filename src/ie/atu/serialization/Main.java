package ie.atu.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Serializable {

	private static final long serialVersionUID = 100L;

	public static void main(String[] args) {
		Person employeeObject1 = new Person("G12345678", "Murphy");
		File outputByteFile = new File(".\\resources\\employeeByteFile.ser");
		FileOutputStream outputByteFileStream = null;
		ObjectOutputStream outputByteFileStreamForObjects = null;
		
		// Print out Employee Fields
		System.out.println(employeeObject1.toString());

		// Serialization
		try {
			// Saving of object to a file
			outputByteFileStream = new FileOutputStream(outputByteFile);
			outputByteFileStreamForObjects = new ObjectOutputStream(outputByteFileStream);

			// Method for serialization of object
			outputByteFileStreamForObjects.writeObject(employeeObject1);

			outputByteFileStreamForObjects.close();
			outputByteFileStream.close();

			System.out.println("Object has been serialized");
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} // End try/catch

	} // End main
} // End Class
