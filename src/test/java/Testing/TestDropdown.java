package Testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown {

	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);  // implicit wait

		driver.get("https://www.wikipedia.org");
		
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		
		Select select = new Select(dropdown);
		
		select.selectByVisibleText("Galego");
		
		select.selectByValue("bg");
		
		select.selectByIndex(7);
		
		// find all the webelements of the dropdown through Select class
		
		List<WebElement> ls = select.getOptions();
		
		System.out.println(ls.size());
		
		// find all the webelements of the dropdown through manually
		
		List<WebElement> ls2 = driver.findElements(By.tagName("option")) ;
		
		int b = ls2.size();
		
		String value = ls2.get(0).getAttribute("value");
		
		String text = ls2.get(0).getText();
		
//		for(int i =0; i<ls2.size(); i++) {
//			
//			System.out.println(ls2.get(i).getText() + " and attribute value is: "+ ls2.get(i).getAttribute("value")+ " and attribute lang is: "+ ls2.get(i).getAttribute("lang"));
//			ls2.get(i).click();
//		}
		
		//System.out.println("4th option attribute name: "+ value + " and 6th option text name: "+ text);
		
		
		
		// find all the links on the page
		List<WebElement> ls3 = driver.findElements(By.tagName("a")) ;
		
		int a = ls3.size();
		
				
		System.out.println("Total links on this page: "+a);
		
//		for(int i=0; i<ls3.size(); i++) {
//			
//			System.out.println(ls3.get(i).getText() + " " + ls3.get(i).getAttribute("href") );
//		}
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[8]"));
		
		List<WebElement> l4 = block.findElements(By.tagName("a"));
		
		int c = l4.size();
		
		
		System.out.println("Total links on this block: "+c);
		
		for(int i=0; i<l4.size(); i++) {
			
			System.out.println(l4.get(i).getText() + " " + l4.get(i).getAttribute("href") );
		}
		

	}

}
