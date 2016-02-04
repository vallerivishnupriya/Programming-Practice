package com.wbl.login.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wbl.login.controllers.ControllerPage;
import com.wbl.login.dataobjects.DataSheet;
import com.wbl.login.utils.CSVReaderUtils;

public class LoginTest {
	
	static String  csvFilePath=null;
	final static Logger logger = Logger.getLogger(LoginTest.class);
	@Parameters({"csvfile"})
	@BeforeClass
	public void setup(String csvFile)
	{
		logger.info("Entering into Before Class and csvfile path is " + csvFile);
		csvFilePath= csvFile;
	}
	@DataProvider(name="accountsDetails")
	public static Object[][] getData()
	{
		List<DataSheet> csvValues= CSVReaderUtils.getCSVValues(csvFilePath);
		DataSheet[] array = csvValues.toArray(new DataSheet[csvValues.size()]);

		Object[][] data=new Object[array.length][1];
		for(int i=0;i< array.length; i++) {
		data[i][0]=array[i];
		}
		return data;
	}
	
	@Test(dataProvider="accountsDetails")
	public void loginTest(DataSheet data)
	{
		logger.info("Testing now User name"+ data.getUserName() + " : and password is " + data.getPassword());
		String pageTitle= ControllerPage.doLogin(data);
		Assert.assertTrue(pageTitle.contains(data.getUserName()));
	}
	@AfterClass
	public void shutdown()
	{
		ControllerPage.driver.quit();
	}
	
	
}
