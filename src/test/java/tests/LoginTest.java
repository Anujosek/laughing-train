package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Accountpage;
import pageobjects.Landingpage;
import pageobjects.Loginpage;
import resources.Base;

public class LoginTest extends Base{
	
	public WebDriver driver;
	Logger log;
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedStatus) throws IOException {
		
		
		Landingpage landingpage=new Landingpage(driver);
		landingpage.MyAccountDropdown().click();
		log.debug("Clicked on MyAccount option");
		landingpage.loginOption().click();
		log.debug("Clicked on login Option");
		
	/*	Logout logout=new Logout(driver);
		logout.MyAccountDropdown().click();
		logout.loginOption().click();*/
		
		Loginpage loginpage=new Loginpage(driver);
		loginpage.emailaddressField().sendKeys(email);
		log.debug("Email id got entered");
		loginpage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginpage.loginButton().click();
		log.debug("Clicked on login button");
		
		Accountpage accountpage=new Accountpage(driver);
		String actualResult;
		try {
		if(accountpage.AccountInformationOption().isDisplayed()) {
			actualResult="Successful";
			log.debug("User logged in");
		}
		}catch(Exception e) {
			actualResult="failure";
			log.debug("User could not login");
		}
		
	}
	@BeforeMethod
	public void openApplication() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver=initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application Url");
	}
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data= {{"anu.aimit.2010@gmail.com","1234","Successful"},{"dummy@test.com","dummy","failure"}};
		return data;
	}

}
