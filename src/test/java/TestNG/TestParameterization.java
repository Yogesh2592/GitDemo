package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParameterization {

	public static WebDriver driver;
	
	@BeforeMethod
	public void navigate() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
		
	}

	@Test(dataProvider= "getData")
	public void doLogin(String username, String password, String role) {

		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);

	}

	@DataProvider()
	public Object[][] getData() {

		ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");

		String sheet = "logintest";

		int rowNum = excel.getRowCount(sheet);
		int colNum = excel.getColumnCount(sheet);

		Object[][] data = new Object[rowNum - 1][colNum];

		System.out.println(excel.getCellData(sheet, 1, 2));
		
		System.out.println("Total rows are : "+rowNum+"  total cols are : "+colNum);

		/*
		 * data[0][0] = excel.getCellData(sheetName, 0, 2); 
		 * data[0][1] = excel.getCellData(sheetName, 1, 2); 
		 * data[0][2] = excel.getCellqData(sheetName, 2, 2);
		 * 
		 * 
		 * data[1][0] = excel.getCellData(sheetName, 0, 3); 
		 * data[1][1] = excel.getCellData(sheetName, 1, 3); 
		 * data[1][2] = excel.getCellData(sheetName, 2, 3);
		 */

		for (int rows = 2; rows <= rowNum; rows++) {

			for (int cols = 0; cols < colNum; cols++) {

				// data[0][0] = excel.getCellData(sheetName, 0, 2);
				// data[0][1] = excel.getCellData(sheetName, 1, 2);

				data[rows - 2][cols] = excel.getCellData(sheet, cols, rows);

			}

		}

		return data;
	}
}
