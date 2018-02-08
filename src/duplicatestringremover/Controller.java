package duplicatestringremover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

	public Controller() throws IOException {
		// Sets up a stored file location
		FileReader fileReader = new FileReader("bin/TestFile.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		// Reads in the file one line at a time
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}
		bufferedReader.close();

		System.out.println("Original Message");
		System.out.println("----------------");
		// Calls a method to display the stored message
		displayText(lines);
		// Iterates through each string in lines
		for (int i = 0; i < lines.size(); i++) {
			// Splits each word up
			String[] words = lines.get(i).split("\\s+");
			// Iterates through each word in the current line
			for (int j = 0; j < words.length; j++) {
				// Skips words with less than 3 characters
				if (words[j].length() < 3) {
					continue;
				}
				// Calls a function to remove duplicate characters
				words[j] = removeDuplicateChars(words[j]);
			}
			// Replaces the current line with the new version
			lines.set(i, convertToString(words));
		}

		System.out.println();
		System.out.println("Updated Message");
		System.out.println("---------------");
		// Calls a method to display the new message
		displayText(lines);
	}

	/**
	 * Removes duplicate characters from the passed in string
	 * 
	 * @param word
	 *            - Original word to be edited
	 * @return - passed in string with duplicate characters removed
	 */
	public String removeDuplicateChars(String word) {
		// Iterates through each character in the current word, except for the last one
		for (int i = 1; i < word.length(); i++) {
			// Stores the current character to inspect
			char currentChar = Character.toLowerCase(word.charAt(i - 1));
			String temp = word.substring(i).toLowerCase();
			int location = temp.indexOf(currentChar);
			// Loops while the current character has a duplicate
			while (location >= 0) {
				// Removes the duplicate character
				word = word.substring(0, location + i) + word.substring(location + i + 1);
				// Checks for another duplicate
				temp = word.substring(i).toLowerCase();
				location = temp.indexOf(currentChar);
			}
		}
		return word;
	}

	/**
	 * Displays the message in the passed in array list
	 * 
	 * @param message
	 *            - message to display
	 */
	public void displayText(ArrayList<String> message) {
		for (String current : message) {
			System.out.println(current);
		}
	}

	/**
	 * Converts array of words to a sentence with spaces
	 * 
	 * @param words
	 *            - array of words to be converted
	 * @return - generated sentence
	 */
	public String convertToString(String[] words) {
		String sentence = words[0];
		// Appends each word onto the end of the current sentence
		for (int i = 1; i < words.length; i++) {
			sentence = sentence + " " + words[i];
		}
		return sentence;

	}

	public static void main(String[] args) {
		try {
			new Controller();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
