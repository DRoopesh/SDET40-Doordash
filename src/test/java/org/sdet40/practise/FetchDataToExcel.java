package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataToExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//Step1: Convert the physical file into java readable object
	FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
	//Step2: Open the excel workbook
	Workbook wb = WorkbookFactory.create(fis);
	//Step3: Get the control on the sheet
	Sheet sheet = wb.getSheet("Sheet1");
	//Step4: Get the control on the row for new row
	Row row = sheet.createRow(3);
	//Step5: Create the cell
	Cell cell0 = row.createCell(0);
	Cell cell1 = row.createCell(1);
	Cell cell2 = row.createCell(2);
	Cell cell3 = row.createCell(3);
	//Step6: Update/set data in the cell
	cell0.setCellValue("browser");
	cell1.setCellValue("chrome");
	cell2.setCellValue("firefox");
	cell3.setCellValue("Edge");
	FileOutputStream fos = new FileOutputStream("./src/test/resources/Test.xlsx");
	//Step7: Write the data into the file
	wb.write(fos);
	
	System.out.println("Data updated successfully");
	//Step8: Close the workbook
	wb.close();	
}
}
