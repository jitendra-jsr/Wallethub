package com.wh.qa.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wh.qa.base.TestBase;
import com.wh.qa.pages.WallethubProfilePage;
import com.wh.qa.pages.WallethubTestInsurancePage;
import com.wh.qa.util.TestUtil;

public class WHTest extends TestBase
{
	WallethubProfilePage w1;
	WallethubTestInsurancePage w2;
	TestUtil tu;


	public WHTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		tu = new TestUtil();
		w1 = new WallethubProfilePage();
		w2 = new WallethubTestInsurancePage();

		driver.get(prop.getProperty("whUrl"));

	}

	@AfterMethod()
	public void teardown()
	{
		try {
			tu.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

	@Test
	public void myReviewTest()
	{
		tu.scrollingByCoordinatesofAPage();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		tu.mymousehover(driver, w1.starsselection);
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		
		String mycss = "//span[contains(text(),'Select...')]";
	    driver.findElement(By.xpath("//span[contains(text(),'Select...')]")).click();
		
		//w2.clickOnDropdown.click();
		
		//w2.clickSelectDropDown();
		//tu.clickOn(driver, w2.clickOnDropdown, 10000);
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}

		List<WebElement> e = driver.findElements
				(By.xpath("/html[1]/body[1]/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[3]/section[1]"
						+ "/modal-dialog[1]/div[1]/div[1]/write-review[1]/div[2]/ng-dropdown[1]/div[1]/ul[1]/li"));
	    for (int i = 0; i < e.size(); i++) {
	        String temp = e.get(i).getText();
	        if (temp.equals("Health Insurance")) 
	        {
	            e.get(i).click();             
	            break;
	        }
	        //System.out.println(temp);
	    }
	    
	    // review area
	    //w2.clickOnReviewArea();
	    driver.findElement(By.xpath("/html[1]/body[1]/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[3]/section[1]/modal-dialog[1]/div[1]/div[1]/write-review[1]/div[2]/div[1]/textarea[1]")).click();
	    
	    // write reviewa
	    //w2.writeReview("hello,,,,,,,,,,,");
	    driver.findElement(By.xpath("/html[1]/body[1]/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[3]/section[1]/modal-dialog[1]/div[1]/div[1]/write-review[1]/div[2]/div[1]/textarea[1]"))
	    .sendKeys("Wallet Hub Namaste --------------------------------- Wallet Hub Namaskara-----------------------------------------"
	    		+ "Wallet Hub Namaskaram----------------------------------Wallet Hub vanakam------------------------------------------"
	    		+ "Wallet Hub world !!");
	    
	    //submit reviewa 
	    //w2.clickOnSubmit();
	    driver.findElement(By.xpath("//div[contains(text(),'Submit')]")).click();
	}

}
