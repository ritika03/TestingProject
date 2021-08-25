package com.pageobject;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import net.serenitybdd.core.pages.PageObject;




public class Login{
	
	WebDriver driver;
	
	@FindBy( xpath="//input[@id='identifierId']" )
	WebElement username;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement next_btn;
	
	@FindBy(xpath="//*[@id=\"password\"]/div[1]/div/div[1]/input")
	WebElement pswd;
	
	
	@FindBy(xpath=" //input[@id='c3']")
	WebElement show_pswd;
	
    @FindBy(xpath="//span[contains(text(),'Next')]")
    WebElement next_btn1;
    
    @FindBy(xpath="//span[contains(text(),'Create account')]")
    WebElement create_acc;
    
    @FindBy()
    WebElement forget_pswd;
    
    @FindBy(xpath="//span[contains(text(),'Wrong password')]")
    WebElement type1;
    
   
    @FindBy(xpath="//header/div[2]/div[1]/div[4]/div[1]/a[1]/img[1]")
    WebElement logo;
    
    @FindBy(xpath="//body[1]/table[3]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/table[2]/tbody[1]/tr[1]/td[2]")
    WebElement subject;
    
    @FindBy(xpath="//tbody/tr[1]/td[3]/a[1]/span[1]")
    WebElement body;
    
    
   public void check_email()
   {
   List <WebElement> emails =driver.findElements(By.xpath("//header/div[2]/div[2]/div[2]"));
  int c= emails.size();
 
  for (int i=0; i<c;i++){
	  if(c!=0)
	  {
      System.out.println("Emails are present:" + emails.get(i));
  }
	  else
	  {
		  System.out.println("No emails present");
	  }
  
  }
   }
    public Login(WebDriver driver) {
        this.driver = driver;
    }
        
        
		public void create(String type,String user , String pass) throws InterruptedException {
    		// TODO Auto-generated method stub
        	
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        	
        	username.sendKeys(user);
        	next_btn.click();
        	pswd.sendKeys(pass);
        	checkPass();
        	
        next_btn1.click();
        
     
        
        if(type.equals("valid")){
        	
        	String actualTitle = driver.getTitle();
        	String expectedTitle="Gmail-Inbox";
        	Assert.assertEquals(actualTitle, expectedTitle,"true");
        	
           
        }else
        {
        	String actualTitle = driver.getTitle();
        	String expectedTitle="Gmail-Inbox";
        
        	Assert.assertEquals(actualTitle, expectedTitle,"Wrong password.Try again or click Forgot password to reset it");
        }

        }
   
      
   	  

        public void check_String(String expectedString)
    	{
        	 List <WebElement> emails =driver.findElements(By.xpath("//header/div[2]/div[2]/div[2]"));
    		for (int i = 0; i < emails.size(); i++) {
    			
    				
    			expectedString = "Hello,this is a testng program";
    			String actualString= emails.get(i).getText();
    			Assert.assertEquals(actualString, expectedString);
    			
    			}
    		}
    	
   
	public void checkPass()
    {
    	if(pswd.isSelected())
    	{
    		System.out.println("password is visible");
	}
    	
    	else
    	{
    		System.out.println("password isnt visible");
    	}
    }
    
  
  
    	
       
	}
	
   

