package DataDriven;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData 
{
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	public ReadExcelData(String excelPath, String sheetName) 
	{
		try 
		{
			wb = new XSSFWorkbook("D:\\Myworkplace\\SeleniumProject1\\Excel\\ExcelSheet.xlsx.xlsx");
			sheet = wb.getSheet("Sheet1");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		getRowCount();
		geColCount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
	}
	public static int getRowCount() throws IOException
	{
		int rowCount=0;
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows: " +rowCount);
		return rowCount;
	}
	public static int geColCount() throws IOException
	{   
		int colCount=0;
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No of colunm: " +colCount);
		return colCount;
	}

	public static String getCellDataString(int rowNum, int colNum) 
	{
		String cellData = null;
		try 
		{
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);
		} catch (Exception exp) 
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}

	public static void getCellDataNumber(int rowNum, int colNum) 
	{ try 
	{
		double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		//System.out.println(cellData);
	} catch (Exception exp) 
	{
		System.out.println(exp.getMessage());
		System.out.println(exp.getCause());
		exp.printStackTrace();
	}
	}


}
