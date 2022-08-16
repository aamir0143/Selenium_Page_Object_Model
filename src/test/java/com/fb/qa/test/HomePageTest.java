package com.fb.qa.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.FriendsPage;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.pages.ProfilePage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	FriendsPage friendsPage;
	ProfilePage profilePage;
	Logger log = Logger.getLogger(HomePageTest.class);
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("*** Starting test cases execution  ****");
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		friendsPage = new FriendsPage();
	}
	
	@Test(priority=6)
	public void verifyHomePageTitleTest() throws InterruptedException {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
//		Thread.sleep(3000);
	}
	@Test(priority=7)
	public void verifyFriendsLinkTest() throws InterruptedException {
		friendsPage = ((HomePage) homePage).clickOnfriendsLink();
		Thread.sleep(3000);
	}
//	@Test(priority=3)
//	public void verifyUploadPicTest() throws IOException, InterruptedException {
//		//profilePage.clickOnprofilePage();
//		//homePage.clickOnAddPictureLink();
//		((HomePage) homePage).clickOnAddPictureLink();
//		Thread.sleep(1000);
//	}
	


//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
