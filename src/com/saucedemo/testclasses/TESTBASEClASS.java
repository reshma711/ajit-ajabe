package com.saucedemo.testclasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.saucedemo.pomclasses.LoginPomClass;

public class TESTBASEClASS {
	  WebDriver driver;
	  @Parameters("brousername")
	  
	  @BeforeMethod
public void setUp(String brousername)
 {
	if(brousername.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver_win32\\chromedriver.exe");

	 driver=new ChromeDriver();
	
	}
	else
	{
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver\\geckodriver.exe");
				 driver=new FirefoxDriver();
   }
	
	 driver.get("https://www.saucedemo.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
 
LoginPomClass x=new LoginPomClass(driver);
	x.method1();
	x.method2();
	x.method3();
	
//	Assert.assertTrue(false);      for checking depends on methods
			
 }
			
  

 
@AfterMethod
public  void tearDown() throws IOException
{
	Date d=new Date();
	SimpleDateFormat d1=new SimpleDateFormat("MM-dd-yy&HH-mm-ss");
	
	String date=d1.format(d);
	
	 TakesScreenshot ts=(TakesScreenshot)driver;
	   
	  File selefile=ts.getScreenshotAs(OutputType.FILE);
	    File myfile=new File("C:\\Screenshot1\\saucedemo"+date+".jpg");
	    FileHandler.copy(selefile, myfile);

//	driver.close();
}


  












}





















