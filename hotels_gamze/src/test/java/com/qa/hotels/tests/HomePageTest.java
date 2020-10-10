package com.qa.hotels.tests;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.utils.Constant;


public class HomePageTest {
	HomePage homePage;
	Properties prop;
	BasePage basePage;
	WebDriver driver;	
	Constant constants;

		@BeforeTest
		public void setUp(){
			
			basePage = new BasePage();
			prop = basePage.init_properties();
			String browserName = prop.getProperty("browser");
			driver = basePage.init_driver(browserName);
		    driver.get(prop.getProperty("url"));
			homePage= new HomePage(driver);
			
		}

		@Test(priority=1,enabled=true,description= "Verify home page title")
		public void testHomePageTitle() throws InterruptedException{
			Thread.sleep(2000);
			String title = homePage.verifyTitle();
			System.out.println("Home page title is: "+title);
			Assert.assertEquals(title, Constant.HOME_PAGE_TITLE);
		}
		
		@Test (priority=2,description="Test booking info and connecting the search page")
		public void testBookingInfo() throws InterruptedException{
			
		homePage.bookingInfo();
		homePage.search();
			
		}
		
		@AfterTest
		public void tearDown(){
			driver.quit();
		}
	}
