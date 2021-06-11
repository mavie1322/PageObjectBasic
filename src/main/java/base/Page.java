package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;
import utilities.ExtentManager;


public class Page {
	
	public static  WebDriver driver;
	public static TopMenu menu;
	public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger(Page.class.getName());
    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\qawithbg\\excel\\Book.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	public Page() {
		if (driver == null) {

			PropertyConfigurator.configure("./src/test/resources/com/qawithbg/properties/log4j.properties");
			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\qawithbg\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("Config is loaded!!!!");
			

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\qawithbg\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//log.info("OR is loaded!!!!");
			log.info("OR is loaded");

			// Jenkins Browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
				browser = System.getenv("browser");
			} else {
				browser = config.getProperty("browser");
			}
			config.getProperty("browser", browser);

			// Browser set up
			if (config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("Firefox is launched!!!!!");
			}

			else if (config.getProperty("browser").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				// to disable any notifications and infobars
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("disable-extensions");
				options.addArguments("disable-infobars");
				driver = new ChromeDriver(options);
				log.info("Chrome is launched!!!!!");
			}

			else if (config.getProperty("browser").equals("ie")) {
				WebDriverManager.iedriver().setup();
				// System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +
				// "\\src\\test\\resources\\executable\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				log.info("Internet Explorer is launched!!!!!");
			}

			driver.get(config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			driver.manage().window().maximize();
			menu = new TopMenu(driver);
		}

	}
	public static void quit() {
		driver.quit();
	}
	
	//Common Keyword
	
	public static boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		}

		catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void click(String locator) {
		
		if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		else if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
		else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		else if(locator.endsWith("_CLASS")) {
			driver.findElement(By.className(OR.getProperty(locator))).click();
		}
		else if(locator.endsWith("_LINK")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).click();
		}
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}

	public static void type(String locator, String value) {
		
		if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_CLASS")) {
			driver.findElement(By.className(OR.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_LINK")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).sendKeys(value);
		}
		
		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);
	}

	static WebElement dropdown;

	public void select(String locator, String value) {
		
		if(locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_CLASS")) {
			dropdown = driver.findElement(By.className(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_LINK")) {
			dropdown = driver.findElement(By.linkText(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);
	}
	
	

}
