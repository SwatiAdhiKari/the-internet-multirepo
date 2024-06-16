package stepDef;

import dataProvider.ConfigFileReader;
import pageObject.ABTestingPageObject;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class StepDefinition {
	ConfigFileReader configFileReader;
	ABTestingPageObject pageObject;
	WebDriver driver;
	
	@Given("User navigates to the-Internet url")
	public void user_navigates_to_the_internet_url() {
				//driver.get("https://www.google.co.in/");
		pageObject = new ABTestingPageObject(driver);
		driver = pageObject.setUp();
		pageObject.navigateToUrl();
	}
	
	@When("User clicks on A\\/B Testing link")
	public void user_clicks_on_a_b_testing_link() {

		pageObject = new ABTestingPageObject(driver);
		pageObject.clickOnABTestingLink();
	}
	
	@Then("User should be navigated to AB Test Variation {int} page.")
	public void user_should_be_navigated_to_ab_test_variation_page(Integer int1) {
		pageObject = new ABTestingPageObject(driver);
		pageObject.quitBrowser();
		System.out.println("-----Quit-----");
	}
	
}
