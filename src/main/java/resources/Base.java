package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class Base {
	
	WebDriver driver;
	public Properties prop;
		public WebDriver initializeDriver() throws IOException {
			
			prop=new Properties();
			String propPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
			FileInputStream fi=new FileInputStream(propPath);
			prop.load(fi);
			String browsername=prop.getProperty("browser");
			if(browsername.equalsIgnoreCase("chrome")) {
				
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				
			}else if(browsername.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}else if(browsername.equalsIgnoreCase("Microsoft edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			driver.manage().window().maximize();
			return driver;			
			}
		public String takeScreenshot(String testName,WebDriver driver) throws IOException {
			File SourceFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String DestinationFilePath=System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
			FileUtils.copyFile(SourceFile,new File(DestinationFilePath));
			return DestinationFilePath;
		}
}

