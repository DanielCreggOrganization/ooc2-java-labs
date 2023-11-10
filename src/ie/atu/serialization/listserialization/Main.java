package ie.atu.serialization.listserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Use a constant for the file path
        final String FILE_PATH = "./resources/cars.ser";
        List<Car> carList1 = new ArrayList<>(); // Create Arraylist to store Cars

        // Create 2 Car objects to be serialized
        Car carObject1 = new Car("John", 3);
        Car carObject2 = new Car("Micheal", 5);

        // Add both car objects to the arraylist
        carList1.add(carObject1);
        carList1.add(carObject2);
        System.out.println("Car list created and populated!");
        System.out.println(carList1);

        // ******************** Serialize List of Cars ******************** //
        try (
            // Create a file output stream to write bytes to a file
            FileOutputStream outputFileStream = new FileOutputStream(FILE_PATH);
            // Create an object output stream to write objects the file output stream
            ObjectOutputStream outputObjectStream = new ObjectOutputStream(outputFileStream)
        ) {
            // Serialize ArrayList object of Cars and stream to file for storage
            outputObjectStream.writeObject(carList1);
            System.out.println("Car list object has been serialized!");
        } catch (Exception ex) { // Catch all exceptions
            ex.printStackTrace(); // Print exception details
        }

        // ******************* Deserialize List of Cars ******************* //
        try (
            // Create a file input stream to read bytes from a file.
            FileInputStream inputFileStream = new FileInputStream(FILE_PATH);
            // Create an object input stream to read objects from the file input stream.
            ObjectInputStream inputObjectStream = new ObjectInputStream(inputFileStream)
        ) {
            // Suppress warning for unchecked cast. There is no way to check at runtime if the ArrayList contains Car objects.
            @SuppressWarnings("unchecked") 
            // Deserialize ArrayList object of Cars and stream from file
            List<Car> carList2 = (ArrayList<Car>) inputObjectStream.readObject();
            System.out.println("Car list object has been deserialized!");
            System.out.println(carList2.toString());
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
    }
}