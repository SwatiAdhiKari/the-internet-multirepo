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
import org.openqa.selenium.interactions.Actions;

import dataProvider.ConfigFileReader;

public class ContextMenuPageObject {

	ConfigFileReader reader;
	WebDriver driver;
	
	public ContextMenuPageObject(WebDriver driver) {
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
	
	public void clickOnContextMenuLink() {
		WebElement ContextMenuLink = driver.findElement(By.xpath("//*[text()='Context Menu']"));
		click(ContextMenuLink);
		WebElement heading = driver.findElement(By.xpath("//h3"));
		System.out.println("Heading : " +heading.getText());
		Assert.assertTrue("User is navigated to Broken images page", heading.getText().equals("Context Menu"));
		
	}
	
	
	public void rightClickOnBox() {
		WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		Actions action = new Actions(driver);
		action.contextClick(box).perform();
	}
	
	public boolean isAlertPresent() {
		try {
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			driver.switchTo().alert().accept();
			return true;
		}
		catch (NoAlertPresentException e) {
			System.out.println(e);
			return false;
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
