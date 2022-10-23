package ie.atu.io;

import java.io.*;

public class HamletReadWriteBytesWithBuffer {

	public static void main(String[] args) throws Exception {
		File fileToCopy = new File("./resources/inputHamlet.txt"); 
		File copyFileDest = new File("./resources/outputHamlet.txt");
		FileInputStream inputStream = new FileInputStream(fileToCopy);
		InputStreamReader streamReader = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(streamReader);
		FileWriter out = new FileWriter(copyFileDest);
		
		String next;
		while((next = br.readLine()) != null) {
			out.write(next);
			out.write("\n");
		}
		
		System.out.println(fileToCopy.getName() + " has been copied to " + copyFileDest.getName());
		
		// Clean up
		out.flush();
		out.close();
		br.close();
	}

}
