package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.RETC_065dataproviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_065POM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_065Test {
	private WebDriver driver;
	private String NewUrl;
	private RETC_065POM RETC_0655POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RETC_0655POM = new RETC_065POM(driver);
	    NewUrl = properties.getProperty("NewURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(NewUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		 //driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = RETC_065dataproviders.class)
    public void RETCTest(String UserName,String Password,String Name,String Slug,String Description,String Title,String Body,String Phrase) throws InterruptedException
    {
    
        RETC_0655POM.Login(UserName,Password,Name,Slug,Description,Title,Body,Phrase);
        screenShot.captureScreenShot("screenshots");
        
    }}