package com.fb.qa.test;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase{
	LoginPage loginPage;
	SignUpPage signUpPage;
	HomePage homePage;
	Logger log = Logger.getLogger(SignUpPageTest.class);
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("*** Starting test cases execution  ****");
		initialization();
		loginPage = new LoginPage();
		signUpPage = new SignUpPage();
		homePage = new HomePage();
		
	}
	

	@Test(priority=1)
	public void createNewAccountTest() {
		signUpPage.createNewAccount().signup(prop.getProperty("firstName"), 
				prop.getProperty("lastName"), prop.getProperty("emailAddress"),
				prop.getProperty("remailAddress"), prop.getProperty("password"), 
				prop.getProperty("day"), prop.getProperty("month"), prop.getProperty("year"));
	}
	

	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}


}
