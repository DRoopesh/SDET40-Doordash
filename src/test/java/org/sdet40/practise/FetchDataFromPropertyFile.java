package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
public static void main(String[] args) throws IOException  {
	//Step1---> Convert the physical file into Java readable object 
	FileInputStream fis = new FileInputStream("./src/test/resources/CommonDataFile.properties");
	
	//Step2---> Create object for properties
	Properties property = new Properties();
	
	//Step3---> Load all the keys
	property.load(fis);
	
	//Step4---> Fetch the data
	String url = property.getProperty("url");
	String browser = property.getProperty("browser");
	
	System.out.println(url);
	System.out.println(browser);
}
}
