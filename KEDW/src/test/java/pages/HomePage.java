package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.Util;
import test.BaseTest;


public class HomePage extends BaseTest

{
	
	@FindBy(xpath = "//*[@class='cbp-l-grid-projects-desc uppercase text-center' and text()='Clinic Management System']//parent::div/div/div/a/img")
	WebElement appCMS;	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String clickCMSApp() throws InterruptedException 
	{
	
		
		logr.info("Method Name: clickCMSApp");
		
		WebDriverWait wait = new WebDriverWait(driver, Util.IMPLICIT_WAIT);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+companyname+"']//parent::div/div/div/a/img")));
		
		if(driver.findElement(By.xpath("//*[text()='"+companyname+"']//parent::div/div/div/a/img")).isDisplayed())
		{
			if(driver.findElement(By.xpath("//*[text()='"+companyname+"']//parent::div/div/div/a/img")).isEnabled())
			{
			driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
	
			driver.findElement(By.xpath("//*[text()='"+companyname+"']//parent::div/div/div/a/img")).click();
			
			}
		}
		else if(!driver.findElement(By.xpath("//*[text()='"+companyname+"']//parent::div/div/div/a/img")).isDisplayed())
		{
			logr.info("Entered company is not available or please check the company name and try again");
			System.out.println("Entered company is not available or please check the company name and try again");
		}	
		
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
		
		if(driver.getCurrentUrl().contains("Dashboards"))
		{
			appCMS.click();
		}
		
		return driver.getCurrentUrl();
	}
}

