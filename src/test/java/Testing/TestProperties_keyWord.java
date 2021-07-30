package Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties_keyWord {
	
	public static WebDriver driver;
	
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static String filename;
	public static String sspath = ".\\screenshot\\"+filename;
	
	public static Logger log = Logger.getLogger(TestProperties_keyWord.class.getSimpleName());
	
	public static void launchBrowser() {
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		if(config.getProperty("browser").equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser has been launched");
			
		}else if(config.getProperty("browser").equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox browser has been launched");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		
	}
	
	public static void navigate() {
		
		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to Test URL: "+ config.getProperty("testsiteurl"));
	}
	
	public static void type(String locatorkey, String value) {
		
		if(locatorkey.endsWith("_XPATH")) {
		
			driver.findElement(By.xpath(OR.getProperty(locatorkey))).sendKeys(value);
			
		}else if (locatorkey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorkey))).sendKeys(value);
		}else if(locatorkey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorkey))).sendKeys(value);
		}
		
		log.info("Typing in an Element : "+locatorkey+" entered value as : "+value );
	}
	
	public static void click (String locatorkey) {
		
		if(locatorkey.endsWith("_XPATH")) {
			
			driver.findElement(By.xpath(OR.getProperty(locatorkey))).click();
		}else if (locatorkey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorkey))).click();
		}else if(locatorkey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorkey))).click();
		}
		log.info("Clicking on an Element : "+locatorkey);
	}
	
public static void capturescrenshot() {
		
		try {
			
			Date d = new Date();
			
			filename = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
			
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(".\\screenshot\\"+filename));
		}
		catch(IOException i) {
			
		}
	}

public static void mailsend()  {
	
	MonitoringMail mail = new MonitoringMail();
	try {
		mail.sendMail(TestMailConfig.server, TestMailConfig.from, TestMailConfig.to, TestMailConfig.subject, TestMailConfig.messageBody, sspath, filename);	
	}
	catch(AddressException a) {
		
	}
	catch(MessagingException m) {
		
	}
	

}
	
	public static void main(String[] args) throws IOException{
		
		
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
		
		OR.load(fis);
		
		fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		
		config.load(fis);
		
		launchBrowser();
		navigate();
		type("FB_username_XPATH", "9654478317");
		type("FB_password_XPATH", "9811509821");
		click("FB_signInBtn_XPATH");
		log.info("Execution has been completed...!!!");
		capturescrenshot();
		log.info("Screenshot has been captured...!!!");
		//mailsend();
		//log.info("Mail has been send...!!!");


	}

}
