package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class RETC_036 {

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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@href='http://realestate.upskills.in/region/villas-in-bangalore/']")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[@class='orig']")).sendKeys("Nullam hendrerit apartment");
		driver.findElement(By.xpath("//*[@class='overlap']")).click();
		Thread.sleep(1000);
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    Thread.sleep(5000);
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		Thread.sleep(1000);
	 	driver.findElement(By.xpath("//*[@class='button fullwidth margin-top-20']")).click();
		JavascriptExecutor jss=(JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[@name='name']")).sendKeys("selenium");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email']")).sendKeys("selenium@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='subject']")).sendKeys("apartment");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='id:comments']")).sendKeys("looking for apartment");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='wpcf7-form-control wpcf7-submit']")).click();
		
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

