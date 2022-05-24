package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.BaseTest;

public class GenericMethods extends BaseTest
{
	public static final long WAIT_FOR_ELEMENT = 2000;
	public static long IMPLICIT_WAIT = 5000;
	protected WebDriverWait wait = new WebDriverWait(driver, GenericMethods.IMPLICIT_WAIT);
}
