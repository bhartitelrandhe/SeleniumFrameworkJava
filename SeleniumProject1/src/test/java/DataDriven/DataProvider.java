package DataDriven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class DataProvider 
{
	
	WebDriver driver = null;

	@BeforeTest
	public void setUpTest() 
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Myworkplace\\SeleniumDemo\\Drivers\\geckodriver.exe" );
		driver = new FirefoxDriver();
	}


	@org.testng.annotations.Test(dataProvider = "test1data")
	public void test1(String username, String passward) throws InterruptedException
	{
		System.out.println(username+" | "+passward);

		driver.get("https://www.theindianfashion.in/my-account/");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(passward);
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
	}



	@org.testng.annotations.DataProvider(name = "test1data")
	public Object[][] getData() throws IOException 
	{
		String excelPath = "D:\\Myworkplace\\SeleniumProject1\\Excel\\ExcelSheet.xlsx.xlsx";
		String SheetName = "Sheet1";
		Object data[][] = testData(excelPath, SheetName);
		return data;
	}

	public Object[][] testData(String excelPath, String SheetName) throws IOException 
	{
		ReadExcelData excel = new ReadExcelData(excelPath, SheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.geColCount();

		Object data[][] = new Object[rowCount-1][colCount];

		for(int i=1;i<rowCount; i++) 
		{
			for(int j=0; j<colCount; j++) 
			{
				String cellData = excel.getCellDataString(i,j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;

	}


}
