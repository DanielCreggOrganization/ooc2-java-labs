package ie.atu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyFileChar {
	public static void main(String args[]) {

		// Create stream references
		FileReader charInputStream = null;
		FileWriter charOutputStream = null;
		int c; // Create int to read and write chars.

		// Protect stream creation and read/write code as it may throw an exception
		try {
			charInputStream = new FileReader("resources/input.txt");
			charOutputStream = new FileWriter("resources/output.txt");

			System.out.println("Byte \t| Character");
			System.out.println("-------------------");

			while ((c = charInputStream.read()) != -1) {

				// Show bytes and characters copied - http://www.asciitable.com/
				System.out.printf("%d \t| %c\n", c, c);
				// Sleep for 500 milliseconds (i.e. half a second) so we can watch write process
				TimeUnit.MILLISECONDS.sleep(500);
				charOutputStream.write(c);
			}

			System.out.println("------------------");
			System.out.println("Copy completed sucessfully! See resources/output.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Try and finally close streams
			try {
				// If the streams got opened then close them
				if (charInputStream != null) {
					charInputStream.close();
				}
				if (charOutputStream != null) {
					charOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finihsed reading and writing.");
	} // End main
} // End Class
