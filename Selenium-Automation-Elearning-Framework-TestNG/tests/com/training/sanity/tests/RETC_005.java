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

public class RETC_005 {

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
		driver.get("http://realestate.upskills.in/change-password/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.name("current_pass")).clear();
		driver.findElement(By.name("current_pass")).sendKeys("misconception@123");
		Thread.sleep(2000);
		driver.findElement(By.name("pass1")).clear();
		driver.findElement(By.name("pass1")).sendKeys("Mennacerocks@123");
		Thread.sleep(2000);
		driver.findElement(By.name("pass2")).clear();
		driver.findElement(By.name("pass2")).sendKeys("Mennacerocks@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='margin-top-20 button']")).click();
		driver.close();
		
	}
}
