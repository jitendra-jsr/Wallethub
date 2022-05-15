package com.wh.qa.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wh.qa.base.TestBase;
import com.wh.qa.pages.WallethubProfilePage;
import com.wh.qa.pages.WallethubTestInsurancePage;
import com.wh.qa.util.TestUtil;

public class WalletHubWriteReviewTest extends TestBase
{
	WallethubProfilePage whp;
	WallethubTestInsurancePage whtp;
	TestUtil tu;
	
	public WalletHubWriteReviewTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		tu = new TestUtil();
		whp = new WallethubProfilePage();
		whtp = new WallethubTestInsurancePage();
		
		driver.get(prop.getProperty("whUrl"));
		
	}
	
	@AfterMethod
	public void tearDown(){
		try {
			tu.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	@Test()
	public void verifyWeCanWriteReviews()
	{
		//driver.get(prop.getProperty("whUrl"));
		System.out.println(driver.getTitle());
		tu.scrollingByCoordinatesofAPage();
	
		//tu.moveToElement(driver, whp.starsselection);
		tu.mymousehover(driver, whp.starsselection);
		
		//String mycss = "//span[contains(text(),'Select...')]";
	    //driver.findElement(By.xpath("//span[contains(text(),'Select...')]")).click();
	    
		tu.waitForClickablility(whtp.clickOnDropdown, 5000);
	    //whtp.clickSelectDropDown();
	    
		//whtp.clickOnDropdown.click();
	    
		//tu.waitForElementToBeVisible(driver, (By) whtp.clickOnDropdown, 2000);
		//whtp.clickSelectDropDown();
		
		//tu.spanselectDropdown(driver, whtp.mydropdownValues, "Health Insurance");
		
		List<WebElement> e = driver.findElements
				(By.xpath("/html[1]/body[1]/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[3]/section[1]"
						+ "/modal-dialog[1]/div[1]/div[1]/write-review[1]/div[2]/ng-dropdown[1]/div[1]/ul[1]/li"));
	    for (int i = 0; i < e.size(); i++) {
	        String temp = e.get(i).getText();
	        if (temp.equals("Life Insurance")) 
	        {
	            e.get(i).click();             
	            break;
	        }
	        //System.out.println(temp);
	    }
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    whtp.clickOnReviewArea();
	    
	    whtp.writeReview("hello,,,,,,,,,,,");
	    
	    whtp.clickOnSubmit();
	}
	
	
}
