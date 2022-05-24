package pages;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.GenericMethods;
import helper.Util;
import test.BaseTest;

public class LoginPage extends BaseTest 

{
	WebDriverWait wait = new WebDriverWait(driver, Util.IMPLICIT_WAIT);
	@FindBy(xpath="//*[@id='txtUserName']") 
	WebElement usernameTextbox;
	@FindBy(name="txtPassword") 
	WebElement passwordTextbox;
	@FindBy(id="btnSubmit")
	WebElement loginButton;
	@FindBy(xpath="//*[@id=\"hgcDesktopIcons\"]/div[1]/a/span[2]")
	WebElement titletxt;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
    public void enterUserName(String strUserName) throws InterruptedException
    {   	
		usernameTextbox.clear();    	   	
    	
    	driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
    	
    	usernameTextbox.sendKeys(strUserName);    	
    }

    
    public void enterPassword(String strPassword) throws InterruptedException
    {    	    	
    	driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
    	
       	passwordTextbox.sendKeys(strPassword);
    }

  
    public void clickLogin() throws InterruptedException
    {
    	
    	loginButton.click();
    	 	   	
    }    
    
  /*  public void checktitletxt() throws InterruptedException
    {
    	
    	boolean processname = titletxt.getText() != null;
    	System.out.println(titletxt.getText());
    	
    	if(processname = true)
    {
    		titletxt.click();
    }
    	else
    {
	System.out.println("No Webelement found");
    }
    }
  */  
    
    
    	
	public String loginToCMS(String strUserName,String strPasword) throws IOException, InterruptedException 
	 { 
		  Thread.sleep(3000);
	  
		  this.enterUserName(strUserName);
	  
		  this.enterPassword(strPasword);
	  
		  //Thread.sleep(2000);
	  
		  this.clickLogin();
		  
		  //this.checktitletxt();
	  
		  return driver.getCurrentUrl(); 
	  }

}
