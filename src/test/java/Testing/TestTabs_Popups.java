package Testing;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabs_Popups {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // implicit wait

		driver.get("https://www.amazon.in/");
		
		//driver.get("https://www.primevideo.com/detail/amzn1.dv.gti.cb98311b-5e83-40bc-b054-11b1fb68237d/ref_");
		
		driver.manage().window().maximize();
		
		Set<String> winhand = driver.getWindowHandles();
		
		Iterator<String> iterator = winhand.iterator();
		
		iterator.next();
		
		driver.findElement(By.xpath("//*[@id='pageContent']")).click();
		
		driver.findElement(By.xpath("//*[@id='navSwmHoliday']/a/img")).click();
		
		
		winhand = driver.getWindowHandles();
		iterator = winhand.iterator();
		iterator.next();
		String second_hand = iterator.next();
		
		driver.switchTo().window(second_hand);
		
		
		System.out.println(driver.getTitle());
		
		
		driver.findElement(By.xpath("//*[@id=\"dv-action-box\"]/div/div/div/div[2]/div/span/form/div/span/span/label")).click();
		
		driver.findElement(By.xpath("//*[@id=\"dv-action-box\"]/div/div/div/div[2]/div/span/div/span[1]/span/label/a")).click();
		
	}

}
