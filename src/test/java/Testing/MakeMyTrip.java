package Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  // implicit wait

		driver.get("https://www.makemytrip.com/");
		
		driver.manage().window().maximize();
		
		//*[@id="pageContent"]
		
		//driver.findElement(By.xpath("//*[@id='pageContent']")).click();

	}

}
