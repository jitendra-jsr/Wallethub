package com.wh.qa.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wh.qa.base.TestBase;

public class WallethubTestInsurancePage extends TestBase
{
	//Page Factory - OR:
	
	@FindBy(xpath="//span[contains(text(),'Select...')]")
	public  WebElement clickOnDropdown;
	
	@FindBy(xpath="/html[1]/body[1]/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[3]/section[1]/modal-dialog[1]/div[1]/div[1]/write-review[1]/div[2]/ng-dropdown[1]/div[1]/ul[1]/li")
	public List<WebElement> mydropdownValues;
	
	@FindBy(xpath="/html[1]/body[1]/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[3]/section[1]/modal-dialog[1]/div[1]/div[1]/write-review[1]/div[2]/div[1]/textarea[1]")
	public WebElement reviewArea;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement clickSubmit;
	
	//Actions:
	
	public void clickSelectDropDown()
	{
		clickOnDropdown.click();
		
	}
	
	public void clickOnReviewArea()
	{
		reviewArea.click();
	}
	
	public void writeReview(String review)
	{
		reviewArea.sendKeys(review);
	}
	
	public void clickOnSubmit()
	{
		clickSubmit.click();
	}
	
	
	
}
