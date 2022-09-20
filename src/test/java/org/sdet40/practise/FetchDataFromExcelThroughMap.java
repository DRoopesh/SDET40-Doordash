package org.sdet40.practise;

import java.nio.file.spi.FileSystemProvider;
import java.util.Map;

import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataFromExcelThroughMap {
public static void main(String[] args) {
	ExcelUtility excelUtility = new ExcelUtility();
	
	excelUtility.initializeTheFile(IConstantPath.EXCELFILE_PATH);
	Map<String, String> map = excelUtility.getDataFromExcelInMap("Form");
	System.out.println(map.get("Pincode"));
}
}
