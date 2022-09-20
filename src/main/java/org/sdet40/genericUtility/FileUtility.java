package org.sdet40.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class consists of resusable methods to handle the property file
 * @author DASARI
 *
 */
public class FileUtility {
	Properties property = new Properties();
	/**
	 * This method is used to fetch the data from the property file
	 * @param key
	 * @param string 
	 * @return
	 */
	public String getDataFromPropertyFile(String key) {
		String value = property.getProperty(key).trim();
		return value;
	}
	/**
	 * This method is used to initialize the property file
	 * @param propertyFilePath
	 */
	public void initializeTheFile(String propertyFilePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
