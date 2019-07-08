package com.training.pom;

import java.util.ArrayList;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RETC_066POM {
	
private WebDriver driver; 
	
	public RETC_066POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@href='http://realestate.upskills.in/region/villas-in-bangalore/']")
	private WebElement villa; 
	
	@FindBy(xpath="//*[@href='/contact/']")
	private WebElement drop_us; 
	
	@FindBy(xpath="//*[@type='text' and @name='name']")
	private WebElement Name;
	
	@FindBy(name="email")
	private WebElement Email;
	
	@FindBy(name="subject")
	private WebElement Subject;
	
	@FindBy(name="id:comments")
	private WebElement Message;
	
	@FindBy(xpath="//*[@type='submit' and @value='Send']")
	private WebElement send;
	
	
	public void Login(String Name, String Email, String Subject, String Message) throws InterruptedException {
		this.villa.click();
		Thread.sleep(3000);
		this.drop_us.click();
		Thread.sleep(3000);
		this.Name.sendKeys(Name);
		Thread.sleep(2000);
		this.Email.sendKeys(Email);
		Thread.sleep(2000);
		this.Subject.sendKeys(Subject);
		Thread.sleep(2000);
		this.Message.sendKeys(Message);
		Thread.sleep(2000);
		this.send.click();
		Thread.sleep(2000);
	}
}
