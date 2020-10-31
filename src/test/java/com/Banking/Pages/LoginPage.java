package com.Banking.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Banking.Testcases.BaseTest;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		System.out.println("inside constructor");
		this.driver=driver;
		//PageFactory.initElements(rdriver, this);
	}
	
	//==============================Locators=======================================================//
	//login locators
	By Login = By.xpath("//a[@class='login']");
	
	By username = By.xpath("//input[@id='email']");
	
	By password = By.xpath("//input[@id='passwd']");
	
	By submit = By.xpath("//button[@name='SubmitLogin']");
	
	
	//Contact us locators
	
	By Contact_us = By.xpath("//a[contains(text(),'Contact')]");	
	
	//=====================================Methods================================================//
	
	//Login methods
	
	public WebElement clickLoginbtn() {
		return driver.findElement(Login);
	}
	
	public WebElement setUserName() {
		return driver.findElement(username);
	}
	
	public WebElement setPassword() {
		return driver.findElement(password);
	}
	
	public WebElement clickSubmit() {
		return driver.findElement(submit);
	}
	
	//Contact us methods
	public WebElement Contact_us() {
		return driver.findElement(Contact_us);
	}
}
