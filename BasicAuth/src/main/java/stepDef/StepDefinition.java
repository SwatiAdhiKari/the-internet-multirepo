package stepDef;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pageObject.BasicAuthPageObject;

public class StepDefinition {
	
	public BasicAuthPageObject pageObject;
	WebDriver driver;
	
	@Given("User navigates to the-Internet url")
	public void user_navigates_to_the_internet_url() {
	    pageObject= new BasicAuthPageObject(driver);
	    driver=pageObject.setUp();
	    pageObject.navigateToUrl();
	}
	
	@When("User clicks on Basic Auth link")
	public void user_clicks_on_basic_auth_link() {
	    pageObject= new BasicAuthPageObject(driver);
	    pageObject.clickOnBasicAuthLink();
	}
	
	@When("User enters the credentials in the alert pop-up")
	public void user_enters_the_credentials_in_the_alert_pop_up() {
	    pageObject.enterCredentialsInPopUp();
	}
	
	@When("User enters the incorrect password in the alert pop-up")
	public void user_enters_the_incorrect_credentials_in_the_alert_pop_up() {
	    pageObject.enterIncorrectCredentialsInPopUp();
	}
	
	@Then("User should be able to navigate to Basic Auth page.")
	public void user_should_be_able_to_navigate_to_basic_auth_page() {
	    Assert.assertTrue("User successfully logs in using Auth pop-up",pageObject.isUserInBasicAuthPage());
	    pageObject.quitBrowser();
	}
	
	@Then("User should see Authentication alert again")
	public void user_should_see_authentication_alert_again() {
	    Assert.assertFalse("User can not see successfully logged in message.",pageObject.isUserInBasicAuthPage());
	    pageObject.quitBrowser();
	}
}
