package com.vienna.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vienna.qa.base.TestBase;
import com.vienna.qa.pages.page1;

public class page1Test extends TestBase{
	
	public page1Test() throws IOException {	//Constructor
		super();		//To initialize the properties from the base class method,it will cal super class constructor
	}

	page1 p1;	
	
	
	@BeforeMethod
	public void startup() throws IOException {
		initialization();
		p1 = new page1(); 	//Object creating for calling page1
	}
	
	@Test
	public void titleCheck() {
		p1.title();
	}
	
	@Test(priority = 1)
	public void logoCheck() {
		boolean b=p1.logo();
		Assert.assertTrue(b);
	}
	@Test
	public void Free30Days() throws InterruptedException, IOException {
		p1.free();
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
}
