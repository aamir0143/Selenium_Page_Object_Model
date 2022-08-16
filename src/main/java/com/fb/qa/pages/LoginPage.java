package com.fb.qa.pages;

import com.fb.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{
	
	//page factory - or:
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "pass")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Create New Account']")
	WebElement CreateAccountbtn;
	
	@FindBy(xpath = "//img[@alt='Facebook']")
	WebElement fbLogo;
	
	//Initialize page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);		
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateFBImage() {
		return fbLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	public HomePage loginMultipleAccounts(String un, String pwd) {
		
		username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.submit();
        return new HomePage();
	}

	


}