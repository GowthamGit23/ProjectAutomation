package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import helper.Util;
import pages.LoginPage;


public class LoginTest extends BaseTest
{
	Util util;
	LoginPage loginP;
	
		
	@BeforeMethod
	public void browserLaunch()
	
	{
		DOMConfigurator.configure("log4j.xml");			
		initialization();
		util = new Util();
		loginP = new LoginPage();
	}
		

	@Test
	public void loginToCMS() throws IOException, InterruptedException 	
	{		
	
		logr.info("------------------------------------------------------------------------------------");
		timestamp = util.currentTimeStamp();
		logr.info("Timestamp: " + timestamp + "");
		logr.info("Category: loginCMS");
		
		loginP.loginToCMS(prop.getProperty("Username"),prop.getProperty("Password"));
		
		logr.info("------------------------------------------------------------------------------------");
	}

	
}
