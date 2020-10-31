package com.Banking.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {
	
	public void readData() throws IOException {
		
	FileInputStream inputStream = new FileInputStream("C:\\Users\\SHREE\\eclipse-workspace\\Banking\\src\\test\\java\\com\\Banking\\TestData\\Login_Data_eBanking.xlsx");	
	XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	XSSFSheet sh = wb.getSheet("Sheet2");
		
		int totalrows = sh.getPhysicalNumberOfRows();
		System.out.println("total rows are "+totalrows);
		int totalcols = sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println("total cols are "+totalcols);	
		Object arr[][] = new Object[totalrows-1][totalcols];
		
			for(int i=1;i<totalrows;i++) {
				for(int j=0;j<totalcols;j++) {
				arr[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.println(arr);
								}
				//System.out.println();
			}
			System.out.print(arr);			
				}	
	public static void main(String args[]) throws IOException {
		ExcelReader erd = new ExcelReader();
		erd.readData();
					}
	}

	

