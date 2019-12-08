package com.vienna.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.vienna.qa.utils.WebEventListener;
import com.vienna.qa.utils.Xls_Reader;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static Xls_Reader reader;
	static WebEventListener EventListener;
	static EventFiringWebDriver e_driver;
	
	public TestBase() throws IOException {
	
		 prop = new Properties();
		 try {
			FileInputStream ip = new FileInputStream(
					 "C:\\Users\\chinn\\eclipse-workspace\\VIEN\\src\\main\\java\\com\\vienna\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	public static void initialization() throws IOException {
		System.setProperty("webdriver.chrome.driver", "F:\\Technical\\Dowloads\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		
			 e_driver = new EventFiringWebDriver(driver);	//EventFiringWebDriver class object
				//Create object of EvenetListenerHandler to register it with EventFiringWebDriver
			 EventListener = new WebEventListener();		//com.vienna.qa.utils.WebEventListener
			 e_driver.register(EventListener); 	// we have to register EventListener with EventFiringWebDriver
			 driver = e_driver;			//we have to assign the EventFiringWebDriver[e_driver] to the driver
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	
	}
	public static void excel_path(){
		 reader = new Xls_Reader(
				"C:\\Users\\chinn\\eclipse-workspace\\VIEN\\src\\main\\java\\com\\vienna\\qa\\excelData\\viennaAdvantage.xlsx");
	}
	
		//getElemenet
	public WebElement getElement(String locatorKey) {
		WebElement e = null;
		try {
			if (locatorKey.endsWith("_id"))
				e = driver.findElement(By.id(prop.getProperty(locatorKey)));
			else if (locatorKey.endsWith("_name"))
				e = driver.findElement(By.name(prop.getProperty(locatorKey)));
			else if (locatorKey.endsWith("_xpath"))
				e = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
			else {
				reportFail("Locator not correct - " + locatorKey);
				Assert.fail("Locator not correct - " + locatorKey);
			}

		} catch (Exception ex) {
			// fail the test and report the error
			reportFail(ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Failed the test - " + ex.getMessage());
		}
		return e;
	}
	public void reportFail(String msg) {

	}
	public void click(String xpathele) {

		getElement(xpathele).click();

	}
	
}
