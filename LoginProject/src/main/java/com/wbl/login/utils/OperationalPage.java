package com.wbl.login.utils;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wbl.login.controllers.LoadProperties;
import com.wbl.login.dataobjects.Configuration;
import com.wbl.login.dataobjects.DataSheet;

public class OperationalPage {
	final static Logger logger = Logger.getLogger(OperationalPage.class);
	public static Properties properties;
	public static String googleUrl;
	public static String yahooUrl;
	public static String hotmailUrl;
	public static Configuration config;
	public static WebDriver driver;

	static {
		config = LoadProperties.getConfiguration();
		driver = config.getDriver();
		properties = PropertyUtils
				.readConfigFile("src/main/resources/domain.properties");
		googleUrl = properties.getProperty("gmailurl");
		yahooUrl = properties.getProperty("yahoourl");
		hotmailUrl = properties.getProperty("hotmail");
	}

	public static String loginYahoo(DataSheet data) {
		logger.info("Entered into yahoo login method with username "
				+ data.getUserName() + " password is " + data.getPassword());
		String message = null;
		driver.get(yahooUrl);
		WebDriverWait wait = new WebDriverWait(driver, config.getTimeOut());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='login-username']")));
		WebElement userName = driver.findElement(By
				.xpath(".//*[@id='login-username']"));
		userName.sendKeys(data.getUserName());
		WebElement passWord = driver.findElement(By
				.xpath(".//*[@id='login-passwd']"));
		passWord.sendKeys(data.getPassword());
		driver.findElement(By.xpath(".//*[@id='login-signin']")).click();
		driver.navigate().to("https://in-mg61.mail.yahoo.com/neo/launch");
		message = driver.getTitle();
		System.out.println(message);

		return message;
	}

	public static String loginHotmail(DataSheet data) {
		logger.info("Entered into hotmail login method with username "
				+ data.getUserName() + " password is " + data.getPassword());
		String message = null;
		driver.get(hotmailUrl);
		WebDriverWait wait = new WebDriverWait(driver, config.getTimeOut());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='i0116']")));
		WebElement userName = driver.findElement(By.xpath(".//*[@id='i0116']"));
		userName.sendKeys(data.getUserName());
		WebElement passWord = driver.findElement(By.xpath(".//*[@id='i0118']"));
		passWord.sendKeys(data.getPassword());
		driver.findElement(By.xpath(".//*[@id='idSIButton9']")).click();
		driver.navigate().to("https://outlook.live.com/owa/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='O365_TopMenu']/div/div[2]/div[1]/div[12]/button")));
		driver.findElement(
				By.xpath(".//*[@id='O365_TopMenu']/div/div[2]/div[1]/div[12]/button"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("html/body/div[13]/div/div/div/div/div[1]/div/div/div/div[2]/span[2]")));
		WebElement element = driver
				.findElement(By
						.xpath("html/body/div[13]/div/div/div/div/div[1]/div/div/div/div[2]/span[2]"));
		element.getText();
		return message;
	}

	public static String loginGmail(DataSheet data) {
		logger.info("Entered into gmail login method with username "
				+ data.getUserName() + " password is " + data.getPassword());
		String message = null;
		driver.get(googleUrl);
		WebElement userName = driver.findElement(By.xpath(".//*[@id='Email']"));
		userName.sendKeys(data.getUserName());
		driver.findElement(By.id("next")).click();
		WebDriverWait wait = new WebDriverWait(driver, config.getTimeOut());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("Passwd")));
		WebElement passWord = driver.findElement(By.id("Passwd"));
		passWord.sendKeys(data.getPassword());
		driver.findElement(By.xpath(".//*[@id='signIn']")).click();
		driver.navigate().to("https://mail.google.com/mail/u/0/?tab=wm#inbox");
		message = driver.getTitle();
		System.out.println(message);
		return message;

	}

}
