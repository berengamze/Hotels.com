package com.qa.hotels.tests;

import java.util.Properties;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.SearchPage;
import com.qa.hotels.utils.Constant;

public class TestCase2 {

	
		HomePage homePage;
		Properties prop;
		BasePage basePage;
		WebDriver driver;	
		Constant constants;
		SearchPage searchPage;
		
	@BeforeMethod
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
	@Test
	public void testFourStars() throws InterruptedException {
		System.out.println("Four Star Hotels");
		searchPage.selectFourStar();
		searchPage.hotelsWithinTenMile();
		
	}
	@Test
	public void testFiveStars() throws InterruptedException {
		System.out.println("Five Star Hotels");
		searchPage.selectFiveStar();
		searchPage.hotelsWithinTenMile();
		
		
	}
	@Test
	public void testThreeStars() throws InterruptedException {
		System.out.println("Three Star Hotels");
		searchPage.selectThreeStar();
		searchPage.hotelsWithinTenMile();
		
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	}

