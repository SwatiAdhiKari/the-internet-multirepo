package stepDef;

import dataProvider.ConfigFileReader;
import pageObject.PageObject;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class StepDefinition {
	ConfigFileReader configFileReader;
	PageObject pageObject;
	WebDriver driver;
	
	@Given("User navigates to the-Internet url")
	public void user_navigates_to_the_internet_url() {
				//driver.get("https://www.google.co.in/");
		pageObject = new PageObject(driver);
		driver = pageObject.setUp();
		pageObject.navigateToUrl();
	}
	
	@When("User clicks on Add\\/Remove Elements link")
	public void user_clicks_on_a_b_testing_link() {

		pageObject = new PageObject(driver);
		pageObject.clickOnABTestingLink();
	}
	
	@Then("User should be able to add element.")
	public void user_should_be_able_to_add_element() {
		pageObject = new PageObject(driver);
		pageObject.clickOnAddElement();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue("Element 1 was added.", pageObject.isElementAdded());
		pageObject.quitBrowser();
		System.out.println("-----Quit-----");
	}
	
	@Then("User should be able to remove the added element.")
	public void user_should_be_able_to_remove_the_added_element() {
		pageObject = new PageObject(driver);
		pageObject.clickOnAddElement();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue("Element 1 was added.", pageObject.isElementAdded());
		pageObject.clickOnDeleteElement();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertFalse("Element 1 was deleted.", pageObject.isElementAdded());
		pageObject.quitBrowser();
		System.out.println("-----Quit-----");
	}
	
}
