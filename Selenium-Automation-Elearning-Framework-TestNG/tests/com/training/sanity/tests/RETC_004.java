package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_004 {

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
		loginPOM.sendPassword("misconception@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		driver.findElement(By.xpath("//*[@class='current']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.name("agent_title")).clear();
		driver.findElement(By.name("agent_title")).sendKeys("manzoor");
		Thread.sleep(2000);
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys("9876543210");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='button margin-top-20 margin-bottom-20']")).click();
		
		
	}
}
