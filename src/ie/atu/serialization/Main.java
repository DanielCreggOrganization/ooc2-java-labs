package ie.atu.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {

		Employee employeeObject1 = new Employee("827384773H", "Collins");
		System.out.println("Employee PPSN: " + employeeObject1.getPpsn()+ ", Surname: " + employeeObject1.getSurname() + ", Company" + Employee.COMPANY_NAME);

		// Declare required streams
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
			System.out.println("Object has been serialized!");
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
			System.out.println( employeeObject2.getPpsn() + " " + employeeObject2.getSurname() + " " + Employee.COMPANY_NAME);
			System.out.println("Object has been deserialized");
			System.out.println("Employee PPSN: " + employeeObject1.getPpsn()+ ", Surname: " + employeeObject1.getSurname() + ", Company" + Employee.COMPANY_NAME);
		} catch (IOException IOExc) {
			IOExc.printStackTrace();
		} catch (ClassNotFoundException CNFExc) {
			CNFExc.printStackTrace();
		}

	} // End main method
} // End Main class
