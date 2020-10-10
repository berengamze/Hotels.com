package com.qa.hotels.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.utils.ElementUtil;
import com.qa.hotels.utils.JavaScriptUtil;

public class HomePage extends BasePage{

	ElementUtil elementUtil;
	WebDriver driver;
	JavaScriptUtil javaScriptUtil;
	WebDriverWait wait;

	By continueHotels = By.className("footer-continue-link di-ib fw-bold");
	
	By destinationElement = By.xpath("//*[@id='qf-0q-destination']");
	
	By check_in = By.xpath("//*[@id='qf-0q-localised-check-in']");
	
	By check_out = By.xpath("//*[@id='qf-0q-localised-check-out']");
	
	By room = By.xpath("//*[@id='qf-0q-rooms']");
	By adults = By.xpath("//*[@id='qf-0q-room-0-adults']");
	By children = By.xpath("//*[@id='qf-0q-room-0-children']");
	By child1 = By.id("qf-0q-room-0-child-0-age");
	By child2 = By.id("qf-0q-room-0-child-1-age");
	By search = By.xpath("//*[@class ='cta cta-strong']");
	By ThreeStars = By.xpath("//*[@id='f-star-rating-3']");
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil=new JavaScriptUtil(driver);	
	}
	
	public String verifyTitle(){
		
	return elementUtil.doGetPageTitle();
	
	}
	
	public void bookingInfo() throws InterruptedException{
		
	elementUtil.doSendKeys(destinationElement, "Boston, Massachusetts, United States of America");
	
	elementUtil.doSendKeys(check_in, "8/22/20");
	
	elementUtil.doSendKeys(check_out, "9/02/20");
	
	elementUtil.doSelectSingleDropDown(room, 0);
		
	elementUtil.doSelectSingleDropDown(adults, 2);
	
	elementUtil.doSelectSingleDropDown(children, 2);

	elementUtil.doSelectSingleDropDown(child1, 6);
	
	elementUtil.doSelectSingleDropDown(child2, 10);
	
	Thread.sleep(2000);
	}
	public SearchPage search(){
		 
		elementUtil.doClick(search);
		
		 return new SearchPage(driver);
	}
	
}
