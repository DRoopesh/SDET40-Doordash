package org.sdet40.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of methods to handle excel file actions
 * @author DASARI
 *
 */
public class ExcelUtility {

	Workbook wb = null;
	/**
	 * This method is used to initialize the Excel file
	 * @param excelFilePath
	 */
	public void initializeTheFile(String excelFilePath) {
		FileInputStream fisExcel = null;
		try {
			fisExcel = new FileInputStream(excelFilePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			wb = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to get data from the Excel file based on key
	 * @param sheetName
	 * @param key
	 * @return
	 */
	
	public String getDataFromExcel(String sheetName, String key) {
		Sheet sheet = wb.getSheet(sheetName);
		String value = null;
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			String requiredData = sheet.getRow(i).getCell(0).getStringCellValue();	
			if(requiredData.equalsIgnoreCase(key)) {
				value = sheet.getRow(i).getCell(1).getStringCellValue();
				break;
			}
		}
		return value;
	}
	/**
	 * This method is used to fetch the data from excel based on row number and cell number
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromExcel(String sheetName, int rowNumber, int cellNumber) {
		Sheet sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return data;
	}
	/**
	 * This method is used to fetch the data from excel and stored in Map
	 * @param sheetName
	 * @return
	 */
	public Map<String, String> getDataFromExcelInMap(String sheetName) {
		Sheet sheet = wb.getSheet(sheetName);
		
		Map<String, String> map = new HashMap<>();
		DataFormatter df = new DataFormatter();
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)),df.formatCellValue(sheet.getRow(i).getCell(1)));
		}
		return map;
	}
	/**
	 * This method is used to fetch the data from excel and stored in List<Map>
	 * @param sheetName
	 * @return
	 */
	public List<Map<String,String>> getDataFromExcelInList(String sheetName) {
		Sheet sheet = wb.getSheet(sheetName);
		
		List<Map<String, String>> list = new ArrayList<>();
		DataFormatter df = new DataFormatter();
		for(int k=0; k<=sheet.getRow(0).getLastCellNum(); k++) {
			Map<String, String> map = new HashMap<>();
			for(int i=0; i<=sheet.getLastRowNum(); i++) {
				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(k)));
			}
			list.add(map);
		}
		return list;
	}
	/**
	 * This method is used to fetch the multiple data from excel and return as 2 -dimensional array
	 * @param sheetName
	 * @return
	 */
	public String[][] getMultipleData(String sheetName) {
		Sheet sheet = wb.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		String[][] arr = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
			for(int j=0; j<=sheet.getRow(0).getLastCellNum(); j++) {
				arr[i-1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return arr;
	}
	/**
	 * This method is used to close the Excel workbook
	 */
	public void closeTheWorkbook() {
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}