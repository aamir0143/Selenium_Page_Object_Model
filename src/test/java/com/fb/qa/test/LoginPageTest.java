package com.fb.qa.test;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	String sheetName = "Sheet1";

	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("*** Starting test cases execution  ****");
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=2) 
	public void LoginPageTitle() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Facebook – log in or sign up");
	}
	@Test(priority=3) 
	public void fbLogoImageTest() {
		boolean flag = loginPage.validateFBImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@DataProvider
	public Object[][] getLoginTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	// using Data driven approch
	@Test(priority = 5, dataProvider = "getLoginTestData", description = "verifying multiple login using dataprovider test on login page")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case Desc: Verify multiple loginTest on Login page")
	@Story("Story Name: To check multiple loginPage test")
	public void multipleLoginTest(String userName, String password) throws InterruptedException {
		homePage = loginPage.loginMultipleAccounts(userName, password);
		Thread.sleep(3000);
		log.info("login successful with username: " + userName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
