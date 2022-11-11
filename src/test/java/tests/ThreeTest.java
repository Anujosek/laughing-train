package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{

	public WebDriver driver;
	@Test
	public void testThree() throws IOException {
		System.out.println("Three Test");
		driver=initializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		driver.close();
	}
}
