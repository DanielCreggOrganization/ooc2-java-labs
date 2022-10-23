package ie.atu.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FileCopyWithBufferHamlet {

	public static void main(String[] args) {
		File inFile = null;
		File outFile = null;
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		BufferedReader br = null;
		String data = null;
		String[] wordsArray;

		try {
			inFile = new File("./resources/inputHamlet.txt");
			outFile = new File("./resources/outputHamlet.txt");
			// Create File reader to get data from file.
			fileReader = new FileReader(inFile);
			br = new BufferedReader(fileReader);
			// Create File writer to send data to file.
			fileWriter = new FileWriter(outFile);
			// Read in byte from file and store it
			while ((data = br.readLine()) != null) {
				wordsArray = data.split(" ");
				for (int i = 0; i < wordsArray.length; i++) {
					System.out.print(wordsArray[i] + " ");
					// Write out byte from program and store it out.txt
					fileWriter.write(wordsArray[i] + " ");
					// Sleep for half a second (100 milliseconds)
					TimeUnit.MILLISECONDS.sleep(100);
				}
				System.out.print("\n");
				fileWriter.write("\n");
			}
			System.out.println("Copy Complete!");
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}

			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}
}
