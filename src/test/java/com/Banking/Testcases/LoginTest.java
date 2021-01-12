package com.Banking.Testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Banking.Pages.LoginPage;
import com.Banking.utilities.Screenshots;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider="getdata")
	public void login(String username,String password) throws Exception {
		driver = initialize();	
		LoginPage lp = new LoginPage(driver);
		
		lp.clickLoginbtn().click();		
		Thread.sleep(5000);		
		lp.setUserName().sendKeys(username);
		System.out.println(username);
		logger.info("username entered");
		Thread.sleep(5000);
		
		lp.setPassword().sendKeys(password);
		System.out.println(password);
		logger.info("password entered");
		Thread.sleep(5000);		
		lp.clickSubmit().click();
		Thread.sleep(5000);
		String title = driver.getTitle();
		Thread.sleep(5000);
		Assert.assertEquals(title, "My account - My Store");
		logger.info("title is correct");
	}	
	@DataProvider
	public Object[][] getdata() {
	
			Object[][] arr=new Object[1][2];
				arr[0][0]="ashokbabar2002@gmail.com";
				arr[0][1]="Pavan&56789";	
				return arr;	
			}	
	
	@Test
	public void contact_us() throws InterruptedException {
		driver.get("http://automationpractice.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		logger.info("url launched");
		
		LoginPage lp = new LoginPage(driver);
		lp.Contact_us().click();
		logger.info("clicked on Contact us");
		String contact_us_title = driver.getTitle();
		Assert.assertEquals(contact_us_title, "Contact us - My Store");
		
	}
	
	@Test
	public void create_Account() {
		
	}
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(result.getStatus()==2) {
			
			Screenshots.capturescreen(BaseTest.driver, result.getTestName());
		}
	}	

}
