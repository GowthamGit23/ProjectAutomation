package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.GenericMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties prop;	
	public static Timestamp timestamp;
	public static Logger logr = Logger.getLogger(BaseTest.class);
	public static String companyname;
	
	public BaseTest()
	{
		try
		{			
			DOMConfigurator.configure("log4j.xml");				
						
			prop = new Properties();
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\DataFiles\\testdata.properties");
			
			prop.load(fis);		
						
		}
		
		catch (FileNotFoundException e) 
		{			
			e.printStackTrace();
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}		
	}	

	public static void initialization() 
	{
		
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("1.Adol-Med\n2.Allergy-Immunology\n3.BMCP\n4.Call Schedule\n5.Capital Request\n6.Cardiology\n7.CMS-GOLD-Beta\n8.DDBP\n9.Dermatology\n10.Endocrinology\n11.ERD\n12.ERD-Beta\n13.Gastroenterology\n14.Gen-Peds\n15.Gynecology\n16.HIRC\n17.Human-Genetics\n18.ID\n19.Neonatology\n20.Nephrology\n21.Nephrology-Beta\n22.Neurology\n23.Neurology-Beta\n24.Neurosurgery\n25.Neurosurgery-Beta\n26.Nutrition\n27.Ophthalmology\n28.Orthopedics\n29.Otolaryngology\n30.Pain-Management\n31.Ped-Rehab\n32.Ped-Surgery\n33.Psychiatry\n34.Pulmonary\n35.Rheumatology\n36.Room Management\n37.Room-Management-Beta\n38.Sports-Med");
		System.out.println("");
		System.out.println("Please enter Company/Department/Division name to enter");
		
		companyname = myObj.nextLine();
		
		logr.info("companyname: "+ companyname);
		
		myObj.close();
		
		WebDriverManager.chromedriver().setup();
		
	/*	--------------------------------------To remove Chrome is Controlled by automated software------------------------------------------------*/
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
		 

	/*	--------------------------------------To hide Save Password in Chrome browser while login------------------------------------------------*/
		options.addArguments("--start-maximized");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		
		/*	--------------------------------------Open Chrome in Incognito Window------------------------------------------------*/
		
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		options.setAcceptInsecureCerts(true); //To handle your connection is not private
	
		driver = new ChromeDriver(options);
		
		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("BaseURL1"));

	}
	
	
	
}
