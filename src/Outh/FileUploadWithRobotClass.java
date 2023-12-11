package Outh;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class FileUploadWithRobotClass
{
	@Test
	public static void chromedriver() throws InterruptedException, AWTException
	{
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe");
	//FirefoxOptions option=new FirefoxOptions();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.foundit.in/seeker/registration");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	//JavascriptExecutor j = (JavascriptExecutor)driver;
    //j.executeScript("scroll(0,500)");
	driver.findElement(By.cssSelector("div[class='uploadResume']")).click();
	Robot r=new Robot();
	StringSelection path=new StringSelection("C:\\Users\\hp\\Desktop\\balkrushna\\Balkrushna_tarle_CV_2023.pdf");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
	
	r.delay(2000);
	
	

	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyRelease(KeyEvent.VK_V);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	r.delay(5000);
	
	
	
	

	
	}

}
