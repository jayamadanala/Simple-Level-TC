package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_006 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@class='sign-in']")).click();
		loginPOM.sendUserName("sunil");
		loginPOM.sendPassword("Mennacerocks@123");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='current']")).click();
		driver.findElement(By.xpath("//*[@class='my-account-nav-container']/ul[2]/li[2]/a")).click();
		
	}

	
	
	
	
	
	
	
	
	
	private Object ActionChains(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	private String find_element_by_selector(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

