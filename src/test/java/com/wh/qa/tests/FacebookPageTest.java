package com.wh.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wh.qa.base.TestBase;
import com.wh.qa.pages.FacebookHomePage;
import com.wh.qa.pages.FacebookPage;
import com.wh.qa.util.TestUtil;

public class FacebookPageTest extends TestBase
{
	FacebookPage fb;
	FacebookHomePage hp;
	
	public FacebookPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		fb = new FacebookPage();
		driver.get(prop.getProperty("fbUrl"));
		//fb.login(prop.getProperty("fusername"), prop.getProperty("fpassword"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = fb.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException{
		fb.login(prop.getProperty("fusername"), prop.getProperty("fpassword"));
		
		
	}
	
}
