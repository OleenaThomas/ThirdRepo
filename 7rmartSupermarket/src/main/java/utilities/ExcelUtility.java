package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	public static String getStringData(int a, int b, String sheet) throws IOException {
		f=new FileInputStream(Constant.TESTDATA);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow row=s.getRow(a);
		XSSFCell cell=row.getCell(b);
		return cell.getStringCellValue();
	}
	
	public static int getNumericData(int a, int b, String sheet) throws IOException {
		f=new FileInputStream(Constant.TESTDATA);
		w=new XSSFWorkbook(f);
		s=w.getSheet(sheet);
		XSSFRow row=s.getRow(a);
		XSSFCell cell=row.getCell(b);
		return (int) cell.getNumericCellValue();
	}
}
