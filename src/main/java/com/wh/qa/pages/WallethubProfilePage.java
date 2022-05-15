package com.wh.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wh.qa.base.TestBase;

public class WallethubProfilePage extends TestBase
{
	//Page Factory - OR:
	//@FindBy(xpath="//body/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[3]/section[1]/div[2]/div[3]/review-star[1]/div[1]/*[4]")
	
	@FindBy(xpath="//*[local-name()='svg' and @tabindex=0 and @aria-label='4 star rating']")
	public WebElement starsselection;

	//Actions:
	public void clickOnStars()
	{
		starsselection.click();
	}

}
