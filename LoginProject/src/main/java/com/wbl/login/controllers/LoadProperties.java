package com.wbl.login.controllers;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.wbl.login.dataobjects.Configuration;
import com.wbl.login.utils.PropertyUtils;

public class LoadProperties {
	public static Configuration config = new Configuration();
	static Properties properties = new Properties();
	static {
		setConfiguration();
	}

	private static void setConfiguration() {
		properties =PropertyUtils.readConfigFile("src/main/resources/config.properties");
		config.setTimeOut(Integer.parseInt(properties.getProperty("timeout")));
		config.setDriver(getWebDriver(properties.getProperty("browser")));
	}

	public static Configuration getConfiguration() {
		return config;
	}

	private static WebDriver getWebDriver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			return new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			return new InternetExplorerDriver();
		}
		return null;
	}
}
