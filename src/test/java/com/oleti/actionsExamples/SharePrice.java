package com.oleti.actionsExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SharePrice {
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("https://www.google.com/search?q=covid+cases+in+india&rlz=1C1CHBD_enTH971TH971&sxsrf=AOaemvJeCE7W_4bzpDHlW2h_KF0P7-jDjg%3A1634954020821&ei=JGtzYeetMfvZz7sPwcuTsAk&ved=0ahUKEwjnz4mttt_zAhX77HMBHcHlBJYQ4dUDCA4&uact=5&oq=covid+cases+in+india&gs_lcp=Cgdnd3Mtd2l6EAMyCwgAEIAEELEDEIMBMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgQIABBDOgQIIxAnOgcIABCxAxBDOgcIABDJAxBDOgUIABCSAzoICAAQgAQQsQM6CwgAEIAEELEDEMkDOggIABCABBDJA0oECEEYAFCx384CWOD5zgJgzPvOAmgAcAJ4AIABnwGIAbgSkgEEMC4yMJgBAKABAcABAQ&sclient=gws-wiz");
		
		driver.get("https://www.google.com/search?q=dmart+share+price&rlz=1C1CHBD_enTH971TH971&ei=HINzYayMF7jgz7sPuvyu6AE&ved=0ahUKEwisit-azd_zAhU48HMBHTq-Cx0Q4dUDCA4&uact=5&oq=dmart+share+price&gs_lcp=Cgdnd3Mtd2l6EAMyDwgAELEDEIMBEEMQRhD6ATIECAAQQzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEOgcIABBHELADOgcIABCwAxBDOgUIABCRAjoLCC4QgAQQsQMQgwE6CAgAEIAEELEDOggIABCxAxCDAToICC4QgAQQsQM6BwgAELEDEEM6CgguEMcBENEDEEM6CggAEOoCELQCEEM6CAguELEDEIMBOgsILhCxAxDHARCjAjoOCC4QgAQQsQMQxwEQowI6BQgAELEDOg0ILhDHARCvARBDEJMCOgQILhBDOgoIABCxAxCDARBDOgoILhDHARCjAhBDOgsILhCABBDHARDRAzoNCC4QxwEQowIQQxCTAjoHCAAQgAQQCjoKCAAQsQMQgwEQCjoHCAAQsQMQCjoLCC4QgAQQxwEQrwFKBAhBGABQ0_MBWOCZAmCYmwJoA3ACeACAAYwCiAGWEpIBBjcuMTAuMpgBAKABAbABCsgBCsABAQ&sclient=gws-wiz");
		driver.manage().window().maximize();
	}
	@Test
	public void getPrice()
	{
		WebElement ele=driver.findElement(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])"));
		
		
		int getTopLeftY=((ele.getSize().getHeight())/2)-ele.getSize().getHeight();
		int getTopLeftX=((ele.getSize().getWidth())/2)-ele.getSize().getWidth();
		Actions act=new Actions(driver);
		for(int i=0;i<=100;i++)
		{
			act.moveToElement(ele, getTopLeftX+(i+5), getTopLeftY).perform();
			String price=driver.findElement(By.xpath("//div[@class='knowledge-finance-wholepage-chart__hover-card']//span[@class='knowledge-finance-wholepage-chart__hover-card-value']")).getText();
			String time=driver.findElement(By.xpath("//div[@class='knowledge-finance-wholepage-chart__hover-card']//span[@class='knowledge-finance-wholepage-chart__hover-card-time']")).getText();
			System.out.println("Price:"+price+" time:"+time);
		}
	}

}
