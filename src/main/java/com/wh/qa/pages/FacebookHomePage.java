package com.wh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wh.qa.base.TestBase;

public class FacebookHomePage extends TestBase
{
	//Page Factory - OR:
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]/div[1]/a[1]")
	WebElement homeButton;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement msgsection;

	@FindBy(css="div[aria-describedby*='placeholder']")
	WebElement messageSectionExpanded;
	
	@FindBy(css="div[aria-label='Post']")
	WebElement postMsg;
	
	//Initializing the Page Objects:
	public FacebookHomePage(){
		PageFactory.initElements(driver, this);
	}

	// Actions or Methods
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public  void homePageScreen()
	{
		homeButton.click();
	}
	
	public  void postMessage(String msg)
	{
		msgsection.click();
		messageSectionExpanded.click();
		messageSectionExpanded.sendKeys(msg);
		postMsg.click();
	}
	
	
}
