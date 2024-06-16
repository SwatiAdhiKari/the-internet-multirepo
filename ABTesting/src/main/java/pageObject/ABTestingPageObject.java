package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import dataProvider.ConfigFileReader;


public class ABTestingPageObject {

	ConfigFileReader reader;
	WebDriver driver;
	
	public ABTestingPageObject(WebDriver driver) {
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
		System.out.println("navigation");
		driver.get(reader.getApplicationUrl());
		System.out.println("Done--");
		
	}
	
	public void clickOnABTestingLink() {
		WebElement abTestingLink = driver.findElement(By.xpath("//a[text()='A/B Testing']"));
		
		click(abTestingLink);
		System.out.println("***** In AB Testing *****");
	}
	
	public void click(WebElement locator) {
		locator.click();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}
