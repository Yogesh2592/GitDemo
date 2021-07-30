package Testing;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElements {

	public static void main(String[] args)  {

		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);
////////////////////////////////////////////////////////////////////////////////////////////		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  // implicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, 10);  // explicit wait
		
		
		
		driver.get("https://www.facebook.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("9654478317");
		driver.findElement(By.xpath("//*[@class='inputtext _55r1 _6luy _9npi']")).sendKeys("9811509821");
		
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		//Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@aria-label='Account']")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@class= 'aov4n071']/div[3]/div/div[4]/div/div/div[2]")).click(); // logout
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class= 'aov4n071']/div[3]/div/div[4]/div/div/div[2]"))).click();
		
//		String error = driver.findElement(By.xpath("")).getText();
//		System.out.println(error);
		
		//driver.quit();
		
		
		
		// http://way2automation.com/way2auto_jquery/index.php

	}

}
