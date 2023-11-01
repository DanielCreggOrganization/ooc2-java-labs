package ie.atu.serialization.listserialization;

import java.io.FileInputStream; // Used to read bytes from a file
import java.io.FileOutputStream; // Used to write bytes to a file
import java.io.ObjectInputStream; // Used to read objects from a file
import java.io.ObjectOutputStream; // Used to write objects to a file
import java.util.ArrayList; // Used to create an Arraylist of Cars
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileOutputStream outputFileStream = null; // Used to write bytes to a file
        FileInputStream inputFileStream = null; // Used to read bytes from a file
        ObjectOutputStream outputObjectStream = null; // Used to write objects to a file
        ObjectInputStream inputObjectStream = null; // Used to read objects from a file
        List<Car> carList1 = new ArrayList<>(); // Create Arraylist to store Cars

        // Create 2 Car objects to be serialized
        Car carObject1 = new Car("John F. Kennedy", 3);
        Car carObject2 = new Car("Micheal D. Higgins", 5);

        // Add car objects to the arraylist
        carList1.add(carObject1);
        carList1.add(carObject2);
        System.out.println(carList1);

        // ******************** Serialize List of Cars ******************** //
        try {
            // Create a file output stream to write bytes to a file
            outputFileStream = new FileOutputStream("./resources/cars.ser");
            // Create an object output stream to write objects the file output stream
            outputObjectStream = new ObjectOutputStream(outputFileStream);
            // Serialize Car object and stream to file for storage
            // objectOutStream.writeObject(carObject1);
            // objectOutStream.writeObject(carObject2);
            // Serialize ArrayList object of Cars and stream to file for storage
            outputObjectStream.writeObject(carList1);
            System.out.println("Car list object has been serialized!");
        } catch (Exception ex) { // Catch all exceptions
            ex.printStackTrace(); // Print exception details
        } finally { // Finally block is always executed
            // Close file streams
            try {
                outputFileStream.close(); 
                outputObjectStream.close();
            } catch (Exception ex) { // Catch all exceptions
                ex.printStackTrace(); // Print exception details
            }
        }

        // ******************* Deserialize List of Cars ******************* //
        try {
            // Create a file input stream to read bytes from a file.
            inputFileStream = new FileInputStream("./resources/cars.ser");
            // Create an object input stream to read objects from the file input stream.
            inputObjectStream = new ObjectInputStream(inputFileStream);
            // Suppress warning for unchecked cast
            @SuppressWarnings("unchecked") 
            // Deserialize ArrayList object of Cars and stream from file
            List<Car> carList2 = (ArrayList<Car>) inputObjectStream.readObject();
            System.out.println("Car list object has been deserialized!");
            System.out.println(carList2.toString());
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } finally { // Finally block is always executed
            try { 
                // Close file streams
                inputFileStream.close();
                inputObjectStream.close();
            } catch (Exception ex) { 
                ex.printStackTrace();
            }
        } // End try/catch/finally block

    } // End main method
} // End class