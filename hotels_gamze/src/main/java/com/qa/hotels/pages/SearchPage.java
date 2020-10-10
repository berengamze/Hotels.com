package com.qa.hotels.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.utils.Constant;
import com.qa.hotels.utils.ElementUtil;


public class SearchPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	
	JavascriptExecutor javascriptExecutor;
	By threeStar = By.id("f-star-rating-3");
	//By fourStar = By.id("f-star-rating-4");
	By fiveStar = By.id("f-star-rating-5");
	//By hotelList = By.xpath("//*[@class='hotel-wrap']//a[@class='property-name-link']");
	By fourStars = By.xpath("//*[@id='f-star-rating-4']");
	By distance = By.xpath("//a[contains(text(),'Distance')]");
	By center = By.xpath("//li[@class='section-landmarks root-section']//ul//li//a[contains(text(),'City center')]");
	By hotelListTitle = By.xpath("//*[@class='hotel-wrap']//a[@class='property-name-link']");
	By hotelListMile = By.xpath("//li[contains(text(), 'to City center')]");

	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		homePage=new HomePage(driver);
		
	}
	public String getSecondPageTitle (){
		return elementUtil.waitForGetPageTitle(Constant.SEARCH_PAGE_TITLE);
	}
	public void selectFiveStar() throws InterruptedException{
		driver.findElement(fiveStar).click();;
		Thread.sleep(2000);
	}
	public void selectFourStar() throws InterruptedException{
		driver.findElement(fourStars).click();
		Thread.sleep(2000);
	}
	public void selectThreeStar() throws InterruptedException{
		driver.findElement(threeStar).click();
		Thread.sleep(2000);
	}
	public void findHiltonList() throws InterruptedException{
		
	
		for(int second = 0;; second++){
			if(second >=80){
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
			Thread.sleep(500);
		}
		List<WebElement> hotels = driver.findElements(hotelListTitle);
		for (int i = 0; i < hotels.size(); i++) {
			String list = hotels.get(i).getText();

			if (list.contains("Hilton")) {
				System.out.println("Hilton Hotel list: "+list);
		}		
		Thread.sleep(5000);
	}
}
	public void hotelsWithinTenMile() throws InterruptedException {
		
		
          List<WebElement> hotelList = driver.findElements(hotelListTitle);	
          List<WebElement> hotelMiles = driver.findElements(hotelListMile);			
        
        ArrayList<String> hotelsWithinRadius = new ArrayList<String>();


				for (int i = 0; i < hotelMiles.size(); i++) {
					String hotelName = hotelList.get(i).getText();
					String milesText = hotelMiles.get(i).getText();
	
					String distance = milesText.replaceAll("[a-zA-Z ]", "");
					
					double hotelDistance = Double.parseDouble(distance);
					
					if (hotelDistance < Constant.RADIUS) {
						hotelsWithinRadius.add(hotelName + " is " + milesText);
					}
				}
				for (int i = 0; i < hotelsWithinRadius.size(); i++) {
					System.out.println(hotelsWithinRadius.get(i));
				}
			}

	}