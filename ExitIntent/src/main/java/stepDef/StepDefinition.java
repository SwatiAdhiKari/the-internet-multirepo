package stepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObject.ExitIntentPageObject;

public class StepDefinition {
	
	public ExitIntentPageObject pageObject;
	WebDriver driver;
	
	@Given("User navigates to the-Internet url")
	public void user_navigates_to_the_internet_url() {
	    pageObject= new ExitIntentPageObject(driver);
	    driver=pageObject.setUp();
	    pageObject.navigateToUrl();
	}
	
	@When("User clicks on Exit Intent link")
	public void user_clicks_on_exit_intent_link() throws InterruptedException {
	    pageObject= new ExitIntentPageObject(driver);
	    pageObject.clickOnExitIntentLink();
	}
	
	
	@Then("User moves mouse out of viewport pane")
	public void user_moves_mouse_out_of_viewport_pane() throws InterruptedException {
	    pageObject.moveOutOfViewport();
	}
	
	@Then("User should see the pop up and closes it")
	public void user_should_see_pop_up() {
		Assert.assertTrue("Pop up is present. ",pageObject.isPopUpPresent());
	    pageObject.quitBrowser();
	}
}
