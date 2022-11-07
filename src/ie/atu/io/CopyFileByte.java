package ie.atu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyFileByte {
	public static void main(String args[]) {

		// Create stream references
		FileInputStream byteInputStream = null;
		FileOutputStream byteOutputStream = null;
		// Create int to read and write bytes. Read method returns an int -
		// https://www.oreilly.com/library/view/java-io/1565924851/ch03s02.html
		int b = 0;

		// Protect stream creation and read/write code as it may throw an exception
		try {
			byteInputStream = new FileInputStream("./resources/input.txt");
			byteOutputStream = new FileOutputStream("./resources/output.txt");

			System.out.println("Byte \t| Character");
			System.out.println("-------------------");
			// Read in bytes. NOTE: If no byte is available because the end of the stream
			// has been reached, the returned value is -1.
			while ((b = byteInputStream.read()) != -1) {
				// Show bytes and characters copied - http://www.asciitable.com/
				System.out.printf("%d \t| %c\n", b, b);
				// Sleep for 500 milliseconds (i.e. half a second) so we can watch write process
				TimeUnit.MILLISECONDS.sleep(500);
				// Write byte to output.txt
				byteOutputStream.write(b);
			}
			System.out.println("-------------------");
			System.out.println("Copy completed successfully! See resources/output.txt");
		} catch (FileNotFoundException fnfExceptionObject) {
			System.out.println("Copy FAILED because file not found! See error below:");
			fnfExceptionObject.printStackTrace();
		} catch (InterruptedException ieExceptionObject) {
			System.out.println("Copy FAILED because sleep was interrupted! See error below:");
			ieExceptionObject.printStackTrace();
		} catch (IOException ioExceptionObject) {
			System.out.println("Copy FAILED because write was interrupted! See error below:");
			ioExceptionObject.printStackTrace();
		} finally {
			// Try and finally close streams
			try {
				if (byteInputStream != null) {
					byteInputStream.close();
				}
				if (byteOutputStream != null) {
					byteOutputStream.close();
				}
			} catch (IOException ioObject) {
				ioObject.printStackTrace();
			}
		}
		System.out.println("Finsihed reading and writing.");
	} // End main
} // End Class
