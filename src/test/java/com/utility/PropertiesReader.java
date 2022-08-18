package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	FileInputStream fis;
	String fileName;

	public PropertiesReader(String filename) {
		this.fileName = filename;
	}

	public String getData(String key) {
		Properties pro = new Properties();
		try {
			fis = new FileInputStream("src/test/resources/TestData/" + fileName + ".properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			pro.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro.getProperty(key);
	}
}
