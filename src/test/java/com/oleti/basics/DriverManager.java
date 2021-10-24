package com.oleti.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	WebDriver driver;
	
	@BeforeClass
	public void initializeBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		
	}

	@Test
	public void display()
	{
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
