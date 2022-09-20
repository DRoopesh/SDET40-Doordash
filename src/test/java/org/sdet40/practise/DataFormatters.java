package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFormatters {
	public static void main(String[] args) throws IOException {
		Workbook wb = null;
	try {
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/UsingMethodChaining.xlsx");
		wb =  WorkbookFactory.create(fisExcel);
		
		DataFormatter df = new DataFormatter();
		Sheet sheet = wb.getSheet("Sheet3");
		Cell cell = sheet.getRow(0).getCell(0);
		String data = df.formatCellValue(cell);
		System.out.println(data);
		}
	finally {
			wb.close();
		}
}
}