package com.saucedemo.testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.pomclasses.LOGOUTpomclass;

public class Loginfunctionality extends TESTBASEClASS {



	@Test(priority=1,invocationCount=2)
	public void LoginFunctionality()
	{
	   String expecttitle="Swag Labs";
	   
	   String actualtitle= driver.getTitle();
	   System.out.println(actualtitle);
	   Assert.assertEquals(expecttitle,actualtitle);
	   
	}



	@Test(priority=0,invocationCount=3)
	public void LogoutFunctionlity() {	
		LOGOUTpomclass y=new LOGOUTpomclass(driver);
		y.method1();
		y.method2();

	

	  String expecturl="https://www.saucedemo.com/";
	String actualurl=driver.getCurrentUrl();
	  System.out.println(actualurl);
	  
	  Assert.assertEquals(actualurl, expecturl);


	}












}
