package com.fb.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class HomePage extends TestBase {
	

	@FindBy(xpath = "//span[contains(text(),'Friends')]")
	WebElement friendsLink;
	
//	@FindBy(xpath = "//div[@aria-label='Update profile picture']//i[@class='hu5pjgll lzf7d6o1']")
//	WebElement addPicBtn;
//	
//	@FindBy(xpath = "//span[text()='Upload Photo']")
//	WebElement uploadPhoto;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public FriendsPage clickOnfriendsLink(){
		friendsLink.click();
		return new FriendsPage();
	}
	
//	public void clickOnAddPictureLink() throws IOException
//	{
//		Actions action = new Actions(driver);
//		action.moveToElement(addPicBtn).build().perform();
//		//uploadPhoto.click();
//		driver.findElement(By.xpath("//span[text()='Upload Photo']")).click();
//		Runtime.getRuntime().exec("C:\\Users\\Md Aamir Reza\\Pictures\\demo.exe");
//		
//		
//	}
}