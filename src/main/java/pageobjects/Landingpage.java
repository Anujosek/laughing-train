package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

	WebDriver driver;
	public Landingpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement MyAccountDropdown;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	
	
	public WebElement MyAccountDropdown() {
		return MyAccountDropdown;
	}
	
	public WebElement loginOption() {
		return loginOption;
	}
	
	
}
