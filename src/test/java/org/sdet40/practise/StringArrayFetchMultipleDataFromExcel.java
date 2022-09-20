package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class StringArrayFetchMultipleDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Workbook wb = null;
		try
		{
			FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
			wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("CommonData");
			DataFormatter df = new DataFormatter();
			String[][] arr = new String[sheet.getLastRowNum()+1][sheet.getRow(6).getLastCellNum()];
			for(int i=0; i<sheet.getLastRowNum(); i++)
			{
				for(int j=0; j<sheet.getRow(6).getLastCellNum(); j++)
				{
					arr[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				}
			}
			for(int i=0; i<sheet.getLastRowNum(); i++)
			{
				for(int j=0; j<sheet.getRow(6).getLastCellNum(); j++)
				{
					System.out.print(arr[i][j]+"||");
				}
				System.out.println();
			}
		}
		finally
		{
			wb.close();
		}
	}
}
