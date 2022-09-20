package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchTheDataFromExcel {

public static void main(String[] args) throws IOException  {
	//Step1---> Convert the physical file into Java readable object 
	FileInputStream fisExcel = new FileInputStream("./src/test/resources/TestData.xlsx");
	
	//Object WorkbookFactory;
	//Step2---> Open the Excel workbook
	Workbook wb = WorkbookFactory.create(fisExcel);
	
	//Step3---> Get control on the Excelsheet
	Sheet sheet = wb.getSheet("CommonData");
	
	//Step4---> Get control on the Row
	Row row = sheet.getRow(1);
	Row row1 = sheet.getRow(5);
	
	//Step5---> Get control on the cell
	Cell cell = row.getCell(1);
	Cell cell1 = row1.getCell(1);
	
	//Step6---> Fetch the data
	String userurl = cell.getStringCellValue();
	String adminurl = cell1.getStringCellValue();
	
	System.out.println(userurl);
	System.out.println(adminurl);
}
}