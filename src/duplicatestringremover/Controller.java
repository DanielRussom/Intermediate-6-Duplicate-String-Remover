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
		ArrayList<String> words = new ArrayList<String>();
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			if(line.contains(" ")) {
				System.out.println("Test");
			};
		}

		bufferedReader.close();
		System.out.println();
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
