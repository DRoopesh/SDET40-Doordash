package org.sdet40.practise;

import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantPath;

public class FetchDataFromExcelBasedOnKey {
public static void main(String[] args) {
	ExcelUtility excelUtility = new ExcelUtility();
	
	excelUtility.initializeTheFile(IConstantPath.EXCELFILE_PATH);
	String firstName = excelUtility.getDataFromExcel("Form", "FirstName");
	String lastName = excelUtility.getDataFromExcel("Form", "LastName");	
	String email = excelUtility.getDataFromExcel("Form", "Email");	
	String phoneNumber = excelUtility.getDataFromExcel("Form", "PhoneNumber");	
	String address = excelUtility.getDataFromExcel("Form", "Address");	
	String pinCode = excelUtility.getDataFromExcel("Form", "PinCode");	
	System.out.println(firstName);
}
}
