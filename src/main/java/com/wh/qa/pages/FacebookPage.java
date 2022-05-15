package com.wh.qa.pages;

import org.apache.commons.logging.Log;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wh.qa.base.TestBase;



public class FacebookPage extends TestBase
{
	
	//Page Factory - OR:
	@FindBy(id="email")
	WebElement fbusername;

	@FindBy(xpath="//input[@id='pass']")
	WebElement fbpassword;

	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/button[1]")
	WebElement fbloginBtn;


	//Initializing the Page Objects:
	public FacebookPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public FacebookHomePage login(String un, String pwd){
		fbusername.sendKeys(un);
		fbpassword.sendKeys(pwd);
		//fbloginBtn.click();
		   JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("arguments[0].click();", fbloginBtn);
		    	
		return new FacebookHomePage();
	}
	
	public void createUN(String un)
	{
		fbusername.sendKeys(un);
	}
	public void createPwd(String pwd)
	{
		fbpassword.sendKeys(pwd);
	}
	public void clickCreateAccButton()
	{
		//fbloginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("arguments[0].click();", fbloginBtn);
	}
	
	
}
