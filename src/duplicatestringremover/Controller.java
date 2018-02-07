package duplicatestringremover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	public Controller() throws IOException {
		FileReader fileReader = new FileReader("bin/TestFile.txt");

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}

		bufferedReader.close();
		// Iterates through each string in lines
		for (String current : lines) {
			// Splits each word up
			String[] words = current.split("\\s+");
			// Iterates through each word in the current line
			for (String currentWord : words) {
				// Skips words with less than 3 characters
				if (currentWord.length() < 3) {
					continue;
				}
				// Iterates through each character in the current word, except for the last one
				for (int i = 0; i < currentWord.length() - 1; i++) {
					char currentChar = Character.toLowerCase(currentWord.charAt(i));
					String temp = currentWord.substring(i+1).toLowerCase();
					if(temp.indexOf(currentChar) >= 0) {
						System.out.println(temp);
					}
				}
				System.out.println(currentWord);
			}
		}
	}

	public static void main(String[] args) {
		try {
			new Controller();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
