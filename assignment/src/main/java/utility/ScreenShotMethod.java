package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;


public class ScreenShotMethod {
	String ScreenShotFolderPath = null;
	String ScreenShotFolder = null, ScreenShotPassedFolder = null, ScreenShotFailedFolder = null;
	String ConfigKeysFile = "config.properties";
	
	WebDriver driver;
	public commonMethods cm;
	public webdriverMethods wm;
	
	public ScreenShotMethod() throws Throwable 
	{
		File file = new File(ConfigKeysFile);
		InputStream fis = new FileInputStream(file);
		Properties pf = new Properties();
		pf.load(fis);
		
		ScreenShotFolderPath = pf.getProperty("ScreenShotPath");
		
		cm = new commonMethods();
		wm = new webdriverMethods(driver);
		
		
		ScreenShotFolder = cm.CreateFolder(ScreenShotFolderPath, cm.CurrentDate("dd-MMM-yyyy"));
		ScreenShotPassedFolder = cm.CreateFolder(ScreenShotFolder, "ScreenShot_Passed");
		ScreenShotFailedFolder = cm.CreateFolder(ScreenShotFolder, "ScreenShot_Failed");
	}
	

}
