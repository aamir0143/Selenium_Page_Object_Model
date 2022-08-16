package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class ProfilePage extends TestBase {
//	@FindBy(xpath = "//span[contains(text(),'लॉग आउट करें')]")
//	WebElement logOutPage;
//	
	@FindBy(xpath = "//span[contains(text(),'Er Md Aamir Reza')]")
	WebElement profilePage;
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ProfilePage clickOnprofilePage(){
		profilePage.click();
		return new ProfilePage();
	}
//    public FriendsPage clickOnfriendsLink(){
//		friendsLink.click();
//		return new FriendsPage();
//	}
//	public ProfilePage clickOnprofilePage(){
//		profilePage.click();
//		return new ProfilePage();
//	}
//	public LogOutPage clickOnlogOutPage() {
//		logOutPage.click();
//		return new LogOutPage();
//	}


}