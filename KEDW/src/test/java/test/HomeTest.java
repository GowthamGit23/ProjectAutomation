package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.Util;
import pages.HomePage;



public class HomeTest extends BaseTest
{
	public HomeTest()
	{
		super();
	}
	
	HomePage homepage;
	Util util ;
	
	@BeforeMethod	
	public void setUp()
	{	
		homepage = new HomePage();
		util = new Util();
	}
	
	@Test
	@Parameters({"LoginFor"})
	public void clickonCMSApp(String loginFor) throws IOException, InterruptedException
	{	
				
		logr.info("Method Name: enterCMS - "+loginFor);		
		
		logr.info("Company: "+companyname);
				
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);	
				
		homepage.clickCMSApp();   
		
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);	
		
	}
}
