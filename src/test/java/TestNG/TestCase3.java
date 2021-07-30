package TestNG;


import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {

	@Test (priority=1)
	public static void doUsrReg()
	{
		System.out.println("User Reg has been done");
		
	}
	
	@Test (priority=2, dependsOnMethods = "doUsrReg")
	public static void doLogin()
	{
		System.out.println("User is logged in the application");
		
	}
	
	@Test (priority=3, dependsOnMethods = "doLogin")
	public static void doOrder() {
		
		System.out.println("User order from website");
	}
	
	@Test (priority=4)
	public static void isSkip() {
		
		throw new SkipException("Condition not met hence skipping the test");
	}
	
}
