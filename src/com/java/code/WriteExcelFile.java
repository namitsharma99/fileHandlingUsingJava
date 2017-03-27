package com.java.code;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcelFile {

	public static void main(String[] args) {

		List<String> employees = new ArrayList<String>();
		employees.add("1,Namit,Engineer");
		employees.add("2,Sharma,Developer");

		try {
			writeExcel(employees);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Output will be -
		 * 
		 * 1	Namit	Engineer
		 * 2	Sharma	Developer
		 * 
		 * */

	}

	private static void writeExcel(List<String> employees) throws IOException {

		/*
		 * the thumb-rule for any excel operation is work-book > work-sheet >
		 * row > cell
		 */

		FileOutputStream fileOutputStream = new FileOutputStream(
				"/home/namit/Downloads/writtenExcel.xls");

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet();

		for (int i = 0; i < employees.size(); i++) {
			String row1 = employees.get(i);
			String[] row1Cells = row1.split(",");

			HSSFRow hssfRow = hssfSheet.createRow(i);

			for (int j = 0; j < row1Cells.length; j++) {
				HSSFCell hssfCell = hssfRow.createCell(j);
				hssfCell.setCellValue(row1Cells[j]);
			}

		}

		hssfWorkbook.write(fileOutputStream);
		fileOutputStream.close();
		hssfWorkbook.close();

	}

}
