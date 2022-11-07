package ie.atu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileByteSimple {
	public static void main(String args[]) throws IOException {

		// Create stream references
		FileInputStream byteInputStream = new FileInputStream("./resources/input.txt");
		FileOutputStream byteOutputStream = new FileOutputStream("./resources/output.txt");
		
		// Create int to read and write bytes
		int b = 0;

		// Read in bytes. NOTE: If no byte is available because the end of the stream
		// has been reached, the returned value is -1.
		while ((b = byteInputStream.read()) != -1) {
			byteOutputStream.write(b); // Write out bytes
		}
		
		// Close streams
		byteInputStream.close();
		byteOutputStream.close();
		
		System.out.println("Finished reading and writing!");

	} // End main
} // End Class
