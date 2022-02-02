package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadfromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		try {
			FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\testdata\\inputdata.xlsx");
			// READ THE WORKBOOK
			Workbook wb = new XSSFWorkbook(fi);
			Sheet ws=wb.getSheet("FBLogin");
			
			Row r1=ws.getRow(1);
			Cell c0= r1.getCell(0);
			Cell c1= r1.getCell(1);

			System.out.println(c0);
			System.out.println(c1);

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
