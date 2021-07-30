package TestNG;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParallel {

	@Parameters({"browser", "url"})
	@Test
	public static void dologin(String a, String b) throws InterruptedException {
		
		Date d = new Date();

		System.out.println("Login with browser: "+a+" navigated to URL: "+ b+" "+d.toString() );
		Thread.sleep(2000);

	}

}
