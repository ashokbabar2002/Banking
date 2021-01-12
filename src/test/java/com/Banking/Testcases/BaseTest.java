package com.Banking.Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Banking.utilities.Screenshots;
import com.aventstack.extentreports.model.ScreenCapture;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties ps;
	public static Logger logger;
	
	@BeforeClass
	public  WebDriver initialize() throws Exception {			
		ps = new Properties();
		FileInputStream fis = new  FileInputStream("C:\\Users\\SHREE\\eclipse-workspace\\Banking\\config.properties");
		ps.load(fis);		
		logger = Logger.getLogger("Banking");
		PropertyConfigurator.configure("log4j.properties");
		String browsername = ps.getProperty("browser");
		
		System.out.println(browsername);
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.out.println("isnide if");
			
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//java//com//Banking//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		}
		else if(browsername=="firefox") {
			System.out.println("launch firefox");
			}
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver);
		driver.get(ps.getProperty("URL"));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		logger.info("url launched");
		return driver;
		//return null;
		}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	

	}

