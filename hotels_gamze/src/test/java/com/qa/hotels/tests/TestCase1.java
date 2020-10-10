package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.SearchPage;
import com.qa.hotels.utils.Constant;


public class TestCase1 {

	HomePage homePage;
	Properties prop;
	BasePage basePage;
	WebDriver driver;	
	Constant constants;
	SearchPage searchPage;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		
	     basePage=new BasePage();
	     prop=basePage.init_properties();
	     String browserName = prop.getProperty("browser");
	     driver=basePage.init_driver(browserName);
	     driver.get(prop.getProperty("url"));
	     homePage=new HomePage(driver);
	     homePage.bookingInfo();
	     searchPage=homePage.search();
	     searchPage= new SearchPage(driver);            
	}
	
	@Test(priority=1,enabled=true)
	public void verifySearchPageTitle() {
		
		String title= searchPage.getSecondPageTitle();
		System.out.println("Search page title is: "+ title);
		Assert.assertEquals(title, constants.SEARCH_PAGE_TITLE);
	}
	
	
	@Test(priority=2)
	public void searchThreeStarsHilton() throws InterruptedException {
		searchPage.selectThreeStar();
		searchPage.findHiltonList();
		searchPage.hotelsWithinTenMile();
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
