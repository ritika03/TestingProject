package com.testcases;

import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.data.Data;
import com.ibm.icu.impl.Assert;
import com.pageobject.Login;
import com.testdata.TData;
import com.typesafe.config.Optional;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.pages.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class LoginTC  {
	
	WebDriver driver;
	
	Login log;
	
	
	 @BeforeSuite
	 @Parameter({"browser"})
	 public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("firefox")) {
			 
			System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
				  driver = new FirefoxDriver();	  
				 				

			  }else if (browser.equalsIgnoreCase("chrome")) { 

				  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");

				  driver = new ChromeDriver();
			  }
				  driver.get("https://mail.google.com/");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				

			  } 
	
	 
	
	/* @BeforeSuite
	public void setup(WebDriver driver)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://mail.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}  */

	 @Test(dataProvider = "users",dataProviderClass = TData.class,priority=1)
public void account(String type, String username, String password) throws InterruptedException
	 {

		log=new Login(driver);
		log.create(type,username,password);
		 
	       
	     
	 }
	 @Test(dataProvider = "users",dataProviderClass = TData.class,priority=2)
	public void email(String expected) throws InterruptedException
	{
		
			log=new Login(driver);
			log.check_String(expected);
		
	}
	
		
	
	
	 
	
	@AfterTest
	public void stop()
	{
		driver.quit();
	}
	
}
