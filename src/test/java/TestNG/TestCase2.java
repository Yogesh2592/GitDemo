package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

	@Test
	public void validateTitle() {
		
		System.out.println("Beginning of method");
		String expectedTitle = "PatentBuddy.com";
		String actualTitle= "gmail.com";
		
		// if method check only the java code codition, it doesn't pass or fail the Testcase according to the objective
		
		//softassert is used, so that following line of code after softassert is reachable and executable.
		//asserts class, if fail doesn't allow following line of code reachable and executable.
		
		SoftAssert softassert = new SoftAssert();
		
		softassert.assertEquals(actualTitle, expectedTitle);
		
		softassert.assertTrue(false,"Validation is failed");
		
		softassert.fail("Failing");
		
		System.out.println("Ending of method");
		
		softassert.assertAll();
		
	}
}
