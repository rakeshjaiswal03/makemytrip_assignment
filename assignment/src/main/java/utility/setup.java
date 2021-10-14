package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class setup {
	public static WebDriver driver;
	
	
	public void navigateTo( String URL)
	{
		 driver.navigate().to(URL);

	}
	public WebDriver LaunchChrome(String chromeDriverPath, String URL)
	{
		  System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get(URL);
		  
		  return driver;
	}
	public WebDriver LaunchFirefox(String firefoxDriverPath, String URL)
	{
		  System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
		  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	      capabilities.setCapability("marionette", true);
	      driver = new FirefoxDriver(capabilities);
//	      driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get(URL);
		  
		  return driver;
	}
}
