package pageObject;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
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
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;

import dataProvider.ConfigFileReader;

public class ExitIntentPageObject {

	ConfigFileReader reader;
	WebDriver driver;
	
	public ExitIntentPageObject(WebDriver driver) {
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
	
	public void clickOnExitIntentLink() throws InterruptedException {
		WebElement ExitIntentLink = driver.findElement(By.xpath("//*[text()='Exit Intent']"));
		WebElement ContextMenu = driver.findElement(By.xpath("//*[text()='Context Menu']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(ContextMenu);
		action.build().perform();
		action.contextClick().build().perform();
		Thread.sleep(8000);
				
		click(ExitIntentLink);
		WebElement heading = driver.findElement(By.xpath("//h3[text()='Exit Intent']"));
		System.out.println("Heading : " +heading.getText());
		Assert.assertTrue("User is navigated to Exit Intent page", heading.getText().equals("Exit Intent"));
		
	}
	
	
	public void moveOutOfViewport() throws InterruptedException {
		Thread.sleep(5000);

		System.out.println("done waiting");
		WebElement heading = driver.findElement(By.xpath("//h3[text()='Exit Intent']"));
		Actions action = new Actions(driver);

		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");
		
		action.moveToElement(heading);
		action.build().perform();
		System.out.println("Cursor moved to heading");
		Thread.sleep(7000);
		action.moveByOffset(150, -50);
		action.build().perform();
		action.moveByOffset(0, -8).contextClick();
		action.build().perform();
		
		
		System.out.println("Cursor moved by offset");
		Thread.sleep(5000);
//        PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");
//
//        Sequence actions = new Sequence(mouse, 0)
//                .addAction(mouse.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 12, 0));
//
//        ((RemoteWebDriver) driver).perform(Collections.singletonList(actions));
//		
	}
	
	public boolean isPopUpPresent() {
		try {
			String mainWindow = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> i = handles.iterator();
			String ModalWindow =null;
			while(i.hasNext()) {
				ModalWindow = i.next();
			}
			if(ModalWindow.equals(null)) return false;
			
			driver.switchTo().window(ModalWindow);
			String ModalWindowTitle = driver.findElement(By.xpath("//h3[text()='This is a modal window']")).getText();
			System.out.println("Title - "+ModalWindowTitle );
			Assert.assertTrue("Modal Window Title is present.", ModalWindowTitle.equals("THIS IS A MODAL WINDOW"));
			driver.findElement(By.xpath("//p[text()='Close']")).click();
			driver.switchTo().window(mainWindow);
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
