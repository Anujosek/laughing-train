package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{

	public WebDriver driver;
	@Test
	public void testtwo() throws IOException {
		System.out.println("Test Two");
		driver=initializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		driver.close();
		
	}
}
