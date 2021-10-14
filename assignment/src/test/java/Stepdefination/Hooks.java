package Stepdefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ScreenShotMethod;
import utility.setup;

public class Hooks {
	
	 public ScreenShotMethod ss;
	 String screenshotName = null, screenshotFilePath = null;
	    
	@Before
	public void beforeScenario() throws Throwable {
		
		System.out.println(" <----------------------- Run before the Scenario ------------------------->");
	}

	@After
	public void afterScenario(Scenario scenario) throws Throwable {
		
	
		final byte[] screenshot = ((TakesScreenshot) setup.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
		Thread.sleep(2000);
        
        setup.driver.quit();
		
		System.out.println(" <----------------------- Run After the Scenario ------------------------->");
	}
	

}
