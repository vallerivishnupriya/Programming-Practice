package com.wbl.login.controllers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.wbl.login.dataobjects.DataSheet;
import com.wbl.login.utils.OperationalPage;

public class ControllerPage  {

	public static WebDriver driver;

	static
	{
		driver= LoadProperties.getConfiguration().getDriver();
		driver.manage().timeouts().implicitlyWait(LoadProperties.getConfiguration().getTimeOut(), TimeUnit.SECONDS);
	}

	public static String doLogin(DataSheet data) 
	{

		if(getDomain(data.getUserName()).equals("yahoo")){
			return OperationalPage.loginYahoo(data);
		}else if(getDomain(data.getUserName()).equals("gmail")){
			return OperationalPage.loginGmail(data);
		}else if(getDomain(data.getUserName()).equals("hotmail")){
			return OperationalPage.loginHotmail(data);
		}

		return null;
	}
	
	private static String getDomain(String userName)
	{
		if(userName.toLowerCase().substring(userName.indexOf("@")).contains("gmail"))
		{
			return "gmail";
		} else if(userName.toLowerCase().substring(userName.indexOf("@")).contains("yahoo")){
			return "yahoo";
		}
		else if(userName.toLowerCase().substring(userName.indexOf("@")).contains("ymail"))
		{
			return "yahoo";
		}
		else if(userName.toLowerCase().substring(userName.indexOf("@")).contains("hotmail")){

			return "hotmail";
		}
		
		return "Invalid email";
	}
	
	
}