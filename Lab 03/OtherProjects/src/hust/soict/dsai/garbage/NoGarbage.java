package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

	public static void main(String[] args) {
		String filename = "D:\\02_Assignments and Homework\\Object Oriented Programming\\OtherProjects\\verylongtext.txt";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		try {
			inputBytes = Files.readAllBytes(Paths.get(filename));
			startTime = System.currentTimeMillis();
			StringBuilder outputStringBuilder = new StringBuilder();
			for (byte b : inputBytes) {
				outputStringBuilder.append((char)b);
			}
			String outputString = outputStringBuilder.toString(); // Optional: Convert the StringBuilder to a String in case we need to print it out later
			endTime = System.currentTimeMillis();
			System.out.println(endTime - startTime);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
