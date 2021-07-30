package Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {
	
	public static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
		
		try {
		driver.findElement(by);
		return true;
		}catch(Throwable t) {
			//t.printStackTrace();
			return false;
		}
		
		
		
	}

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // implicit wait

		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		if(isElementPresent(By.xpath("/html/body/div[2]/div/div/button"))) {
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		}


		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div[1]/div/div/div[2]/a[1]")).click();
		
		WebElement men = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/span[3]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(men).perform();
		action.doubleClick(men).perform();
		
		driver.findElement(By.linkText("T-Shirts")).click();

	}

}
