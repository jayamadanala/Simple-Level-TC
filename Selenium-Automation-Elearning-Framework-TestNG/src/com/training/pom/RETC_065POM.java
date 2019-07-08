package com.training.pom;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RETC_065POM {
	
private WebDriver driver; 
	
	public RETC_065POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement UserName; 
	
	@FindBy(id="user_pass")
	private WebElement Password; 
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(id="menu-posts")
	private WebElement options; 
	
	@FindBy(xpath="//a[@href='edit-tags.php?taxonomy=category']")
	private WebElement Categories; 
	
	@FindBy(id="tag-name")
	private WebElement Name;
	
	@FindBy(id="tag-slug")
	private WebElement Slug;
	
	@FindBy(id="tag-description")
	private WebElement Description;
	
	@FindBy(xpath="//*[class='button button-primary']")
	private WebElement AddNewCategory; 	
	
	@FindBy(id="menu-posts")
	private WebElement Posts; 
	
	@FindBy(xpath="//*[@href='post-new.php']")
	private WebElement AddNew; 
	
	@FindBy(name="post_title")
	private WebElement Title;
	
	@FindBy(name="content")
	private WebElement Body;
	
	@FindBy(id="in-category-491")
	private WebElement Checkbox;
	
	@FindBy(id="publish")
	private WebElement Publish;
	
	@FindBy(xpath="//*[@class='display-name']")
	private WebElement admin;		
	
	@FindBy(xpath="//*[@id='wp-admin-bar-logout']/a")
	private WebElement Logout;
	
	@FindBy(xpath="//*[@href='http://realestate.upskills.in/']")
	private WebElement Home;
	
	@FindBy(xpath="//*[@href='http://realestate.upskills.in/blog/']")
	private WebElement Blog;
	
	@FindBy(name="phrase")
	private WebElement Phrase;
	
	
	public void Login(String UserName, String Password, String Name, String Slug,String Description,String Title,String Body,String Phrase) throws InterruptedException {
		
		this.UserName.sendKeys(UserName);
		Thread.sleep(1000);
		this.Password.sendKeys(Password);
		Thread.sleep(1000);
		this.loginBtn.click();
		Thread.sleep(4000);
		Actions act = new Actions(driver);
		act.moveToElement(this.options).build().perform();
		Actions act1 = new Actions(driver);
		act1.moveToElement(this.Categories);		
		this.Categories.click();
		Thread.sleep(2000);
		this.Name.sendKeys(Name);
		Thread.sleep(1000);
		this.Slug.sendKeys(Slug);
		Thread.sleep(1000);
		this.Description.sendKeys(Description);
		Thread.sleep(1000);
		Actions act2 = new Actions(driver);
		act2.moveToElement(this.options).build().perform();
		Actions act3 = new Actions(driver);
		act3.moveToElement(this.AddNew);
		this.AddNew.click();
		Thread.sleep(2000);
		this.Title.sendKeys(Title);
		Thread.sleep(1000);
		this.Body.sendKeys(Body);
		Thread.sleep(1000);
		this.Checkbox.click();
		Thread.sleep(2000);
		this.Publish.click();
		Thread.sleep(2000);
		Actions act4 = new Actions(driver);
		act4.moveToElement(this.admin).build().perform();
		Actions act5 = new Actions(driver);
		act5.moveToElement(this.Logout);
		this.Logout.click();
		Thread.sleep(2000);
		this.Home.click();
		Thread.sleep(2000);
		this.Blog.click();
		Thread.sleep(2000);
		this.Phrase.sendKeys(Phrase);
		
	}
}
