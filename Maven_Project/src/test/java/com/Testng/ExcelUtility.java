package com.Testng;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static Object[][] getExcelData(String filepath,String sheetName) { 
		Object[][] data = null;
		try (FileInputStream fileInputStream = new FileInputStream(filepath);
			Workbook WorkBook= new XSSFWorkbook(fileInputStream)){
			
			Sheet sheet = WorkBook.getSheet(sheetName);
			int totalRows = sheet.getLastRowNum();
			int totalcolumns = sheet.getRow(0).getLastCellNum();
			
			data = new Object[totalRows][totalcolumns];
			
			for(int i=1;i<=totalRows;i++) {
				Row row = sheet.getRow(i);
			for (int j=0;j<totalcolumns;j++) {
				Cell cell = row.getCell(j);
				data[i-1][j]= (cell==null) ? "":cell.toString();   //invalid identifier	
				}
			}
			
		} 
		catch (Exception e) {
		}
		return data;
	}
}
		 
	
	
