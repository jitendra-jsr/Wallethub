package com.wh.qa.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wh.qa.base.TestBase;
import com.wh.qa.pages.FacebookHomePage;
import com.wh.qa.pages.FacebookPage;
import com.wh.qa.util.TestUtil;


public class FacebookHomePageTest extends TestBase{

	FacebookPage fb; 
	FacebookHomePage hp;
	TestUtil tu;
	 
	public FacebookHomePageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		tu = new TestUtil();
		fb = new FacebookPage();
		hp = new FacebookHomePage();
		
		driver.get(prop.getProperty("fbUrl"));
		hp = fb.login(prop.getProperty("fusername"), prop.getProperty("fpassword"));
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
	public void verifyfbHomePageTitleTest(){
		//String homePageTitle = hp.validateHomePageTitle();
		//Assert.assertEquals(homePageTitle, "Facebook");
		
		hp.homePageScreen();
		hp.postMessage("Hello World");
	}
	
	
}
