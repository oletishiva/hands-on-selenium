package com.oleti.tablesExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.*;

public class DynamicTable {

	//elements

	WebElement sharePriceTable;

	WebDriver driver;
	By rows = By.xpath("//tbody/tr");
	By cols = By.xpath("//tbody/tr/td[1]");
	By tableName=By.xpath("//table[@class='dataTable']");

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
	}

	@Test
	public void printTableData() {
		// Table Identification
		
		sharePriceTable=driver.findElement(tableName);
		List<WebElement> rows=sharePriceTable.findElements(By.tagName("tr"));
		for(WebElement e:rows)
		{
			//System.out.println(e.getText());
			List<WebElement> cols=e.findElements(By.tagName("td"));
			//System.out.println("****"+cols.get(0).getText());
			
			  //for (int i=0;i<cols.size();i++) 
			if(cols.size()>0){
			  System.out.println("****"+cols.get(0).getText()); }
			 
			/*
			 * for(WebElement col: cols) { System.out.print("****"+col.getText()+ "*****");
			 * }
			 */
		}

		
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
