package com.wh.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.wh.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 30;
	public static Actions actions;

	//Explicit Wait to Click on WebElement.
	public static void clickOn(WebDriver driver, WebElement element, int timeout) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	//Explicit Wait to Send Data to WebElement.
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	//Explicit Wait for Element To Be Visible.
	public static void waitForElementToBeVisible(WebDriver driver, By locator, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	//To Mouse Hover and Click or Select an Element using Actions Class.
	public static void moveToElement(WebDriver driver, WebElement element) 
	{
		new Actions(driver).moveToElement(element).pause(5000).click().build().perform();
		
	}
	

	public void mymousehover(WebDriver driver, WebElement target)
	{
		Actions act = new Actions(driver);
	    target = driver.findElement(By.xpath("//*[local-name()='svg' and @tabindex=0 and @aria-label='4 star rating']"));
	    act.moveToElement(target).click().build().perform();
	}
	
	// select dropdown
	public static void selectDropdown(WebDriver driver, WebElement element, String type, String value) 
	{
		Select select = new Select(element);
		switch (type) 
		{
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Pass the valid details");
			break;
		}
	}
	
	// span drop down
	public  void spanselectDropdown(WebDriver driver, List<WebElement> element, String value) 
	{
		List<WebElement> e = element;
	    for (int i = 0; i < e.size(); i++) {
	        String temp = e.get(i).getText();
	        if (temp.equals(value)) 
	        {
	            e.get(i).click();             
	            break;
	        }
	        System.out.println(temp);
	    }
		
	}

	// page scroll
	public void scrollingByCoordinatesofAPage() {
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}
	
	// take screenshot
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}


	// clickability
	public static void waitForClickablility(WebElement element, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
