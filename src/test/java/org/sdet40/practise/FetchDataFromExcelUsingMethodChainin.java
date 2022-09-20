package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingMethodChainin {
public static void main(String[] args) {
	FileInputStream fisExcel = null;
	try {
		fisExcel = new FileInputStream("./src/test/resources/UsingMethodChaining.xlsx");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Workbook wb = null;
	try {
		wb = WorkbookFactory.create(fisExcel);
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	Sheet sheet = wb.getSheet("Sheet1");
//	int data = (int) sheet.getRow(0).getCell(0).getNumericCellValue();
//	System.out.println(data);
	
	Sheet sheet = wb.getSheet("Sheet2");
	String data = sheet.getRow(0).getCell(0).toString();
	System.out.println(data);
}
}
