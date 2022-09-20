package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/Test.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sheet = wb.getSheet("CommonData");
		DataFormatter df = new DataFormatter();
		String value = null;
		for(int i=0; i<sheet.getLastRowNum(); i++) //Using if loop
		{
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(key.equalsIgnoreCase("password"))
			{
				for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++) 
				{
					value = df.formatCellValue(sheet.getRow(i).getCell(j));
					System.out.print(value+"||");
				}
			}

		}
	}
}
