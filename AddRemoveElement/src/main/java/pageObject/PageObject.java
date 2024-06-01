package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject {

	ConfigFileReader reader;
	WebDriver driver;

	public PageObject(WebDriver driver) {
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
		WebElement addRemoveElementLink = driver.findElement(By.xpath("//a[text()='Add/Remove Elements']"));
		click(addRemoveElementLink);
		System.out.println("***** In Add/Remove page *****");
	}
	
	public void clickOnAddElement() {
		WebElement AddElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
		click(AddElementButton);
		System.out.println("Element 1 added.");
	}
	
	public void clickOnDeleteElement() {
		WebElement DeleteElementButton = driver.findElement(By.xpath("//button[text()='Delete'][1]"));
		click(DeleteElementButton);
		System.out.println("Element 1 deleted.");
	}
	
	public boolean isElementAdded() {
		try {
			WebElement Element1 = driver.findElement(By.xpath("//button[text()='Delete'][1]"));
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete'][1]")));
			return isDisplayed(Element1);
		}
		catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isDisplayed(WebElement locator) {
		return locator.isDisplayed();
	}
	
	public void click(WebElement locator) {
		locator.click();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}
