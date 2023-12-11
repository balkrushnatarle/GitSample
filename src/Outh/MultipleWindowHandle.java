package Outh;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindowHandle 
{
	
	@Test
	public void multiplewindow() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://toolsqa.com/selenium-training?q=headers");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		 driver.findElement(By.xpath("//a[text()='Demo Site']")).click();
		
		
		String parentwindow=driver.getWindowHandle();
		System.out.println(parentwindow);
		
		
		Set<String>childwindows=driver.getWindowHandles();
		System.out.println(childwindows);
		Iterator<String> it=childwindows.iterator();
		
		while(it.hasNext())
		{
			String childwindow=it.next();
			
			if(!parentwindow.equals(childwindow))
			{
			driver.switchTo().window(childwindow);
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("window.scrollBy(0,2000)");
			Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Forms']")).click();
		
			}
			
		}
		
		driver.switchTo().window(parentwindow);
		
		System.out.println(	driver.getCurrentUrl());
	
		
	}

}
