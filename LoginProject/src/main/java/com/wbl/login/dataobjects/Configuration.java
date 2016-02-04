package com.wbl.login.dataobjects;

import org.openqa.selenium.WebDriver;

public class Configuration {
	public WebDriver driver;
	public int getTimeOut() {
		return TimeOut;
	}
	public void setTimeOut(int timeOut) {
		TimeOut = timeOut;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	private int TimeOut;
	
}