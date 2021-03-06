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
import com.training.dataproviders.RealEstatedataproviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_066POM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_066Test {
	private WebDriver driver;
	private String baseUrl;
	private RETC_066POM RETC_066POM;
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
		RETC_066POM = new RETC_066POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		 driver.quit();
	}


	@Test(dataProvider = "excel-inputs", dataProviderClass = RealEstatedataproviders.class)
	public void loginDBTest(String Name,String Email, String Subject, String Message) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		RETC_066POM.Login(Name, Email, Subject, Message);		
		screenShot.captureScreenShot("send_message");
		
	}}