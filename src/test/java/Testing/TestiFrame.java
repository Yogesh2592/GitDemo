package Testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestiFrame {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // implicit wait

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		driver.manage().window().maximize();
		

		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("/html/body/button")).click();
		
		driver.switchTo().defaultContent();
		
		List<WebElement> ls = driver.findElements(By.tagName("iframe"));
		
		System.out.println("Total no. of iframes: "+ls.size());
		
		for(WebElement f: ls ) {
			
			System.out.println(f.getAttribute("id"));
		}
		
		
		

	}

}
