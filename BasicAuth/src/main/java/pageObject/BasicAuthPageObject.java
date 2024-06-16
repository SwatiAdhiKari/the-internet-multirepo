package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import dataProvider.ConfigFileReader;

public class BasicAuthPageObject {

	ConfigFileReader reader;
	WebDriver driver;
	
	public BasicAuthPageObject(WebDriver driver) {
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
	
	public void clickOnBasicAuthLink() {
		WebElement BasicAuthLink = driver.findElement(By.xpath("//*[text()='Basic Auth']"));
		click(BasicAuthLink);
	}
	
	public void enterCredentialsInPopUp() {
		reader = new ConfigFileReader();
		try {
			driver.get(reader.getApplicationUrl().substring(0, 8)+reader.getUser()+":"+reader.getPassword()+"@"+reader.getApplicationUrl().substring(8)+"basic_auth");
			//String url = reader.getApplicationUrl().substring(0, 8)+reader.getUser()+":"+reader.getPassword()+"@"+reader.getApplicationUrl().substring(8)+"basic_auth";
			//System.out.println("url for pop up handling :"+url);
			//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		}
		catch (NoAlertPresentException e){
			System.out.println("User already logged in.");
			System.out.println(e);
		}
		System.out.println("***** In Basic Auth page *****");
	}
	
	public void enterIncorrectCredentialsInPopUp() {
		reader = new ConfigFileReader();
		try {
			driver.get(reader.getApplicationUrl().substring(0, 8)+reader.getUser()+":"+reader.getIncorrectPassword()+"@"+reader.getApplicationUrl().substring(8)+"basic_auth");
			//String url = reader.getApplicationUrl().substring(0, 8)+reader.getUser()+":"+reader.getPassword()+"@"+reader.getApplicationUrl().substring(8)+"basic_auth";
			//System.out.println("url for pop up handling :"+url);
			//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		}
		catch (NoAlertPresentException e){
			System.out.println("User already logged in.");
			System.out.println(e);
		}
		System.out.println("***** In Basic Auth page *****");
	}
	
	public boolean isUserInBasicAuthPage() {
		try{
			String message = driver.findElement(By.xpath("//div[@class='example']//p")).getText();
		
			WebElement BasicAuthTitle = driver.findElement(By.xpath("//h3[text()='Basic Auth']"));
			System.out.println("Message :"+message);
			System.out.println("Expected message :" +reader.getMessage());
			return (message.equals(reader.getMessage()) && BasicAuthTitle.isDisplayed());
		}
		
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isAuthAlertVisible() {
		waitFor();
		Alert a=driver.switchTo().alert();
		a.dismiss();
		try {
			Alert a1=driver.switchTo().alert();
			a1.dismiss();
			System.out.println("Alert----");
			return true;
		}
		catch (NoAlertPresentException e){
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
