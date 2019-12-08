package com.vienna.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vienna.qa.base.TestBase;
import com.vienna.qa.utils.Xls_Reader;

public class registration extends TestBase {
	
	

	// PageFactry
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtFirstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtLastName']")
	WebElement LastName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtUsername']")
	WebElement username;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPassword']")
	WebElement passw;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPassword']")
	WebElement companyName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEmail']")
	WebElement comapanyEmail;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlCountry']")
	WebElement Country;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCity']")
	WebElement city;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCity']")
	WebElement notARobot;

	@FindBy(xpath = "//label[@id = 'lberms' ]")
	WebElement AcceptCheckBox;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnTRegister']")
	WebElement registerSubmit;

	
	
	
	
	
	
	
	
	// PageObjects
	public registration() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void registrationValues() throws InterruptedException {
			//excelCode
		excel_path();
		String first = 			reader.getCellData("Sheet1", "Firstname", 2);
		String last = 			reader.getCellData("Sheet1", "lastname", 2);
		String user_name = 		reader.getCellData("Sheet1", "username", 2);
		String password = 		reader.getCellData("Sheet1", "password", 2);
		String company_name = 	reader.getCellData("Sheet1", "companyname", 2);
		String companyMail = 	reader.getCellData("Sheet1", "companyemail", 2);
		String location = 		reader.getCellData("Sheet1", "city", 2);
			//WebDriver Code
		FirstName.sendKeys(first);
		LastName.sendKeys(last);
		username.sendKeys(user_name);
		passw.sendKeys(password);
		companyName.sendKeys(company_name);
		comapanyEmail.sendKeys(companyMail);
		city.sendKeys(location);
		notARobot.click();
		Thread.sleep(90000);
		AcceptCheckBox.click();
		registerSubmit.click();
	}

}

















