package stepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObject.ContextMenuPageObject;

public class StepDefinition {
	
	public ContextMenuPageObject pageObject;
	WebDriver driver;
	
	@Given("User navigates to the-Internet url")
	public void user_navigates_to_the_internet_url() {
	    pageObject= new ContextMenuPageObject(driver);
	    driver=pageObject.setUp();
	    pageObject.navigateToUrl();
	}
	
	@When("User clicks on Context Menu link")
	public void user_clicks_on_context_menu_link() {
	    pageObject= new ContextMenuPageObject(driver);
	    pageObject.clickOnContextMenuLink();
	}
	
	
	@Then("User right clicks on the box")
	public void user_right_clicks_on_box() {
	    pageObject.rightClickOnBox();
	}
	
	@Then("User should see the alert and accepts it")
	public void user_should_see_alert() {
		Assert.assertTrue("Alert is present. ",pageObject.isAlertPresent());
	    pageObject.quitBrowser();
	}
}
