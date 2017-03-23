package com.java.code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) {

		String myExcelPath = "sampleExcel.xlsx";
		excelReader(myExcelPath);

	}

	private static void excelReader(String myExcelPath) {
		
		XSSFWorkbook myWorkbook = null;

		try {
			// Create an input stream for your file
			FileInputStream myIpStream = new FileInputStream(myExcelPath);

			// Initiate your excel workbook
			
			// for older .xls-binary files try below (HSSFWorkbook)
			// HSSFWorkbook myWorkbook = new HSSFWorkbook(myIpStream); 

			/* make sure your all poi jars have same version else you would get an exception while parsing -
			 Exception in thread "main" java.lang.IllegalAccessError: tried to
			access method
			org.apache.poi.util.POILogger.log(ILjava/lang/Object;)V from
			class org.apache.poi.openxml4j.opc.PackageRelationshipCollection */
			 
			// Access the workbook
			myWorkbook = new XSSFWorkbook(myIpStream);

			// Initiate the worksheet
			XSSFSheet myWorkSheet = myWorkbook.getSheet("Sheet1");

			/* A generally used method is giving me deprecate warning for getCellTypeEnum(), so I thought of travelling the other road.
			 
			  -> Iterator<Row> myItr = myWorkSheet.iterator();
				 while (myItr.hasNext()) {
			 	 Cell cell = (Cell) myItr.next(); 
			 	 	if (cell.getCellTypeEnum() == CellType.STRING) { 
			 	 		System.out.println(cell.getStringCellValue());
			 		}
			 	}
			 */

			/* Hence I am using the below technique. Also, the cell and row types will change as
			per XSSF or HSSF, whichever type you are using based on excel sheets.
			*/
			
			// fetch all rows of a worksheet, using iterator
			Iterator<Row> xssfRowItr = myWorkSheet.rowIterator();
			
			while (xssfRowItr.hasNext()) {
				
				XSSFRow xssfRow = (XSSFRow) xssfRowItr.next();
				
				// fetch all cells of a row, using iterator
				Iterator<Cell> xssfCellItr = xssfRow.cellIterator();
				
				while (xssfCellItr.hasNext()) {
					
					Cell myCell = xssfCellItr.next();
					
					// fetch the content of each cell
					System.out.print(myCell.getStringCellValue() + "  ");
				}
				
				System.out.println(" ");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != myWorkbook)
					myWorkbook.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
