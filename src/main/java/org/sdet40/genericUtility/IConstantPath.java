package org.sdet40.genericUtility;
/**
 * This interface consists of all external file paths
 * @author DASARI
 *
 */
public interface IConstantPath {
	String PROJECT_PATH = System.getProperty("user.dir");
	String PROPERTYFILE_PATH = PROJECT_PATH+"/src/test/resources/CommonDataFile.properties";
	String EXCELFILE_PATH = PROJECT_PATH+"/src/test/resources/TestData.xlsx";
	String DB_URL = "jdbc:mysql://localhost:3306/tytestdb";
}
