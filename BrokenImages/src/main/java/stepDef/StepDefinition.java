package stepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObject.BrokenImagesPageObject;

public class StepDefinition {
	
	public BrokenImagesPageObject pageObject;
	WebDriver driver;
	
	@Given("User navigates to the-Internet url")
	public void user_navigates_to_the_internet_url() {
	    pageObject= new BrokenImagesPageObject(driver);
	    driver=pageObject.setUp();
	    pageObject.navigateToUrl();
	}
	
	@When("User clicks on Broken images link")
	public void user_clicks_on_basic_auth_link() {
	    pageObject= new BrokenImagesPageObject(driver);
	    pageObject.clickOnBrokenImagesLink();
	}
	
	@Then("User should see broken images")
	public void user_should_see_broken_images() {
	    Assert.assertTrue("User can see broken images.",pageObject.areBrokenImagesVisible());
	    pageObject.quitBrowser();
	}
}
