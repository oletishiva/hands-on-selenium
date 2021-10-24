package com.oleti.basics;

import java.util.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchBrowser {
	
	WebDriver driver;
	By newArrivals=By.xpath("//span[normalize-space()='New arrivals']");

	@BeforeClass
	public void lauchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.pomelofashion.com/th/en/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void display()
	{
		driver.findElement(newArrivals).click();
		System.out.println(driver.getWindowHandle());
		List<WebElement> elements=driver.findElements(By.xpath("//li[contains(@class,'menu-link')]"));
		//
		for(WebElement element:elements)
		{
			System.out.println(element.getText());
		}
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
