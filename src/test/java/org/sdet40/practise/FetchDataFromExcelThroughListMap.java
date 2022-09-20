package org.sdet40.practise;

import java.util.List;
import java.util.Map;

import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataFromExcelThroughListMap {
public static void main(String[] args) {
	ExcelUtility excelUtility = new ExcelUtility();
	
	excelUtility.initializeTheFile(IConstantPath.EXCELFILE_PATH);
	List<Map<String, String>> list = excelUtility.getDataFromExcelInList("Form");
	System.out.println(list.get(3).get("LastName"));
}
}
