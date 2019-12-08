package com.vienna.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vienna.qa.base.TestBase;
import com.vienna.qa.pages.page1;
import com.vienna.qa.pages.registration;

public class registration_Test extends TestBase {
	
	registration reg;
	page1 p1;
	
	public registration_Test() throws IOException {
		// TODO Auto-generated constructor stub
		super();
	}
	@BeforeMethod
	public void startup() throws IOException, InterruptedException {
		initialization();
		p1 = new page1();
		p1.free();
		 	
	}
	
	@Test
	public void registring_values() throws IOException, InterruptedException {
		reg = new registration();	//Object creating for calling page1
		reg.registrationValues();
		
		
	}
	@AfterMethod
	public void TearDown() {
		//driver.quit();
		System.out.println("about to close the driver");
	}
}
