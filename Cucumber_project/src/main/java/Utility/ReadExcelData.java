package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;
import com.sun.media.sound.InvalidFormatException;
import com.sun.rowset.internal.Row;

public class ReadExcelData {
	public static void readPrticularData() {
		try {
			File file = new File("/Users/Admin/Documents/DataDriven_IPT.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");
			Row row = sheet.getRow(3);
			Cell cell =row.getCell(1);
			
			DataFormatter dataFormater = new DataFormatter();
			String data = dataFormater.formatCellValue(cell);
			System.out.println("data");
			
			
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




public static void main(String args[]) {
	readPrticularData();
	
}
}



