package com.fb.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.ProfilePage;

public class ProfilePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	Logger log = Logger.getLogger(ProfilePageTest.class);
	//LogOutPage  logOutPage;
	public ProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("*** Starting test cases execution  ****");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage = new ProfilePage();
	}
	
//	@Test(priority=8)
//	public void verifyHomePageTitleTest() {
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "Facebook");
//	}
	@Test(priority=8)
	public void verifyProfilePageTest() throws InterruptedException {
		profilePage = profilePage.clickOnprofilePage();
		Thread.sleep(3000);
	}
//	@Test(priority=3)
//	public void verifyLogOutPageTest() {
//		logOutPage = profilePage.clickOnlogOutPage();
//	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
