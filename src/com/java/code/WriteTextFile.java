package com.java.code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteTextFile {

	public static void main(String[] args) {

		String storeFileAt = "/home/namit/Downloads/newTextFile.txt";
		try {
			writeFile(storeFileAt);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// output in the created file
		// Hello, this is an example for java coding.
		// Please refer to thecodebuddy.blogspot.in for more!
	}

	private static void writeFile(String storeFileAt) throws IOException {

		FileOutputStream fileOutputStream = null;
		File file = new File(storeFileAt);
		fileOutputStream = new FileOutputStream(file);

		String myContent = "Hello, this is an example for java coding. \n Please refer to thecodebuddy.blogspot.in for more!";

		/*
		 * java.io.FileNotFoundException:
		 * /home/namit/writtenExamples/newTextFile.txt (No such file or
		 * directory)
		 */
		if (!file.exists())
			file.createNewFile();

		fileOutputStream.write(myContent.getBytes());

		fileOutputStream.close();

	}

}
