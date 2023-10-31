package ie.atu.serialization.listserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileOutputStream outputByteFileStream = null; // Used to write bytes to a file
        FileInputStream inputByteFileStream = null; // Used to read bytes from a file
        ObjectOutputStream outputByteFileStreamForObjects = null; // Used to write objects to a file
        ObjectInputStream inputByteFileStreamForObjects = null; // Used to read objects from a file
        List<Car> carList1 = new ArrayList<>(); // Create list of Cars

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

        // De-Serialize List of Cars
        try {
            // Create a file input stream
            inputByteFileStream = new FileInputStream("./resources/cars.ser");
            // Upgrade file input stream to object input stream
            inputByteFileStreamForObjects = new ObjectInputStream(inputByteFileStream);
            // De-Serialize object
            @SuppressWarnings("unchecked") // Suppress warning for unchecked cast
            List<Car> carList2 = (ArrayList<Car>) inputByteFileStreamForObjects.readObject();
            System.out.println("Car list object has been deserialized");
            System.out.println(carList2.toString());
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
        } // End finally block

    } // End main method
} // End class