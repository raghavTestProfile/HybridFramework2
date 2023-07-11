package com.qa.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	public static Properties prop;

	public Utils() {

		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:\\Z99Project\\Configuration\\Config.properties");
			prop.load(fis);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

//	public static String captureScreenshot(WebDriver driver, String testName)  {
//
//		TakesScreenshot screenshot = ((TakesScreenshot) driver);
//
//		File scr = screenshot.getScreenshotAs(OutputType.FILE);
//
//		String dest = System.getProperty("user.dir") + "//Screenshots//" + testName + ".png";
//
//		try {
//			FileHandler.copy(scr, new File(dest));
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//
//		return dest;
//	}

	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String getCellValue(String filename, String sheetname, int rowno, int cellno) throws IOException {

		try {
			fis = new FileInputStream(filename);
			workbook = new XSSFWorkbook(fis);
			excelsheet = workbook.getSheet(sheetname);
			cell = workbook.getSheet(sheetname).getRow(rowno).getCell(cellno);
			
			System.out.println(cell);

			workbook.close();
			
			String value= cell.getStringCellValue().toString().trim();
			String value1=value.split("/")[0];

			return value1;

		} catch (Exception e) {

			return "";
		}

	}

	public static int getRowCount(String filename, String sheetname) throws IOException {

		fis = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fis);
		excelsheet = workbook.getSheet(sheetname);

		int trows = excelsheet.getLastRowNum() + 1;
		workbook.close();

		return trows;

	}

	public static int getColCount(String filename, String sheetname) throws IOException {

		fis = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fis);
		excelsheet = workbook.getSheet(sheetname);

		int ttcells = excelsheet.getRow(0).getLastCellNum();
		workbook.close();

		return ttcells;

	}
}
