package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Accountpage;
import pageobjects.Landingpage;
import pageobjects.Loginpage;
import resources.Base;

public class login extends Base{
	
	WebDriver driver;
	Landingpage landingpage;
	Loginpage loginpage;
	Accountpage accountpage;
	@Given("^Open any browser$")
	public void Open_any_browser() throws IOException {
		driver=initializeDriver();
		
	}
	@And("^Navigate to Login page$")
	public void Navigate_to_Login_page() {
		
		driver.get(prop.getProperty("url"));
		landingpage=new Landingpage(driver);
		landingpage.MyAccountDropdown().click();
		landingpage.loginOption().click();
		
	}
	@When("^User enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void User_enter_username_as_something_and_password_as_something(String email,String password) {
		loginpage=new Loginpage(driver);
		loginpage.emailaddressField().sendKeys(email);
		loginpage.passwordField().sendKeys(password);
	}
	@And("^User clicks on Login button$")
	public void User_clicks_on_Login_button() {
		loginpage.loginButton().click();
	}
	@Then("^Verify user is able to successfully login$")
	public void Verify_user_is_able_to_successfully_login() {
		accountpage=new Accountpage(driver);
		Assert.assertTrue(accountpage.AccountInformationOption().isDisplayed());
	}
	@After
	public void closebrowser() {
		driver.close();
	}
}
