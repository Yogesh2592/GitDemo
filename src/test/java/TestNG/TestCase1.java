package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest
	public static void createDBConnection() {
		
		System.out.println("DB connection has been established");
	}
	
	@AfterTest
	public static void closeDBConnection() {
		
		System.out.println("DB connection has been closed");
	
	}

	@BeforeMethod
	public static void launchBrowser() {
		
		System.out.println("Browser has been launched");
	}
	
	@AfterMethod
	public static void closeBrowser() {
			
		System.out.println("Browser has been closed");
	}
	
	
	@Test (priority=1)
	public static void doUsrReg()
	{
		System.out.println("User Reg has been done");
	}
	
	@Test (priority=2)
	public static void doLogin()
	{
		System.out.println("User is logged in the application");
	}
	
	
	

	
	

}
