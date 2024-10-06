package TestBase;

import java.io.File;

import java.io.FileReader;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties prp;

	
	//setup()
	@BeforeClass
	@Parameters({"OS", "browser"})
	public void setup(String OS, String browser) throws IOException {
		
		//loading property files
		FileReader file = new FileReader("./src/test/resources/config.properties");
		prp = new Properties();
		prp.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(browser) {
		case "chrome": driver = new ChromeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		default: System.out.println("This browser is not supported!");return;
		}
	
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logger.info("**Launching Application!**");
		driver.get(prp.getProperty("appURL"));
	
	}
	
	
	//teardown()
	@AfterClass
	public void tearDown() {
	driver.quit();	
	}
	
	//dynamic random generators 
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
	 
		
	}
	
	public String randomNum() {
		return RandomStringUtils.randomNumeric(10);
	}
	
	public String randomAlphaNum() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(2);
		return(str + num);
	}
	
	public String captureScreenshot(String name) {
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String targetFilePath = System.getProperty("user.dir")+"/screenshots/"+name+" "+ timeStamp+".png";
		 File targetFile = new File(targetFilePath);
		 src.renameTo(targetFile);
		 
		 return targetFilePath;
	}
	
	
	
}