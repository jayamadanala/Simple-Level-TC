package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_035 {

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
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-users']"));
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[@href='user-new.php']")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("user_login")).clear();
		driver.findElement(By.name("user_login")).sendKeys("manzoor300");
		Thread.sleep(1000);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("manzoor300@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.name("first_name")).clear();
		driver.findElement(By.name("first_name")).sendKeys("manzoor1");
		Thread.sleep(1000);
		driver.findElement(By.name("last_name")).clear();
		driver.findElement(By.name("last_name")).sendKeys("mehadi");
		Thread.sleep(1000);
		driver.findElement(By.name("url")).clear();
		driver.findElement(By.name("url")).sendKeys("www.google.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='button wp-generate-pw hide-if-no-js']")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("pass1-text")).clear();
		driver.findElement(By.name("pass1-text")).sendKeys("Manzoor@Mehadi123");
		Thread.sleep(1000);
		Select s1=new Select(driver.findElement(By.id("role")));
		Thread.sleep(1000);
		s1.selectByValue("agent");
		Thread.sleep(3000);
		driver.findElement(By.id("createusersub")).click();;
		Thread.sleep(3000);
		//All users
		Actions action1 = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath("//*[@class='wp-menu-image dashicons-before dashicons-admin-users']"));
		action.moveToElement(element1).perform();
		driver.findElement(By.xpath("//a[@href='users.php']")).click();
		
		
	}
}







