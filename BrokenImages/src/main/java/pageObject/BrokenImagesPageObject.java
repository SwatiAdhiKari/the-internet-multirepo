package pageObject;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import dataProvider.ConfigFileReader;

public class BrokenImagesPageObject {

	ConfigFileReader reader;
	WebDriver driver;
	
	public BrokenImagesPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebDriver setUp() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\swati\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		this.driver = new EdgeDriver();
		driver.manage().window().maximize();
		System.out.println("Set up done");
		return this.driver;
	}
	
	public void navigateToUrl() {
		reader = new ConfigFileReader();
		System.out.print("navigation");
		driver.get(reader.getApplicationUrl());
		System.out.println("-->Done--");
		
	}
	
	public void clickOnBrokenImagesLink() {
		WebElement BrokenImagesLink = driver.findElement(By.xpath("//*[text()='Broken Images']"));
		click(BrokenImagesLink);
		System.out.println("Heading : " +driver.findElement(By.xpath("//h3")));
		WebElement heading = driver.findElement(By.xpath("//h3"));
		Assert.assertTrue("User is navigated to Broken images page", heading.getText().equals("Broken Images"));
		
	}
	
	
	public boolean areBrokenImagesVisible() {
		try{
			int i=0;
			for (WebElement image : driver.findElements(By.tagName("img")))
			{
			    i = isImageBroken(image,i);
			    //System.out.println("i : "+i);
			}
			System.out.println("Number of broken images : "+ i);
			return (true);
		}
		
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	public int isImageBroken(WebElement image, int i)
	{
	    if (image.getAttribute("naturalWidth").equals("0"))
	    {
	        System.out.println(image.getAttribute("outerHTML") + " is broken.");
	        return ++i;
	    }
	    else {
	    	System.out.println(image.getAttribute("outerHTML") + " is not broken.");
	    	return i;
	    }
	}
	
	public void click(WebElement locator) {
		locator.click();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public void waitFor() {
		reader = new ConfigFileReader();
		driver.manage().timeouts().implicitlyWait(reader.getImplicitlyWait(),TimeUnit.SECONDS);
	}
	
}
