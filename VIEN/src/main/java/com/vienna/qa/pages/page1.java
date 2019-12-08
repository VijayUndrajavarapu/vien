package com.vienna.qa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vienna.qa.base.TestBase;

public class page1 extends TestBase {
	
	
		//PageFactory 
	@FindBy(xpath = "//a[@class='navbar-brand']//img")
	WebElement viennaAdvantageLogo ;
	
	@FindBy(xpath = "//a[contains(@class,'try-it-free-btn')]")
	WebElement TryItFree;
	
			//Initializing the page objects
	public page1() throws IOException{
		PageFactory.initElements(driver, this);	//-pointing to current class object
			//To initialize my page factory
	}
	
		//Actions
	public void title() {
		
		String free_title = driver.getTitle();
		System.out.println(free_title+ ">>From page1.java/title() ");
	}
	
	public boolean logo() {
		return viennaAdvantageLogo.isDisplayed();
	}
	public registration free() throws InterruptedException, IOException {
		
		TryItFree.click();
		Thread.sleep(1000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ITWind = windows.iterator();
		
		String parentWindow = ITWind.next();
		String ChildWindow = ITWind.next();
		driver.switchTo().window(ChildWindow);
		Thread.sleep(20000);
		String free_title1 = driver.getTitle();
		System.out.println(free_title1+ ">>From page1.java/free() ");
		
		return new registration();
	}
	
}
