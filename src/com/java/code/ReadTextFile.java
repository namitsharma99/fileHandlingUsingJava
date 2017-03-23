package com.java.code;

import java.io.FileInputStream;

public class ReadTextFile {

	public static void main(String[] args) {

		String myExcelPath = "sample";
		textReader(myExcelPath);

	}

	private static void textReader(String myTextPath) {

		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(myTextPath);
			int c;
			while ((c = fileInputStream.read()) != -1) {
				System.out.print((char) c);
			}

			if (fileInputStream != null) {
				fileInputStream.close();
			}
		} catch (Exception e1) {
			System.out.println(e1);
		}
	}

}
