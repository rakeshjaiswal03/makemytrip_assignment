package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class commonMethods {
	SimpleDateFormat dtFormat;
    Calendar dtCalender;
    Random random;
    String dtReturn;

	
	
	public String SpecificDate(String format,  int days) throws Exception
	{  //format d MM yyyy
		Thread.sleep(5000);
		SimpleDateFormat dtFormat = new SimpleDateFormat(format);
		Calendar dtCalender = Calendar.getInstance();
		dtCalender.add(Calendar.DAY_OF_MONTH,days);
		String dtReturn = dtFormat.format(dtCalender.getTime());
		System.out.println("SpecificDate1 :::"+dtReturn);
		return dtReturn;
	}
	public void Verify(boolean verify, boolean TrueOrFalse) throws InterruptedException
	{	Thread.sleep(2000);
		if (TrueOrFalse == true)
		{
			System.out.println(verify);
			Assert.assertTrue(verify);
		}
		else if (TrueOrFalse == false)
		{
			System.out.println(verify);
			Assert.assertFalse(verify);
		}
	}
	
	public String CurrentDate(String Format)
	{
		 dtFormat=new SimpleDateFormat(Format);  
		 dtCalender=Calendar.getInstance();
		 dtReturn=dtFormat.format(dtCalender.getTime());
		 
		 return dtReturn;
	}
	public String CreateFolder(String FolderPath,String FolderName) throws Exception 
	{
		String CreatedFolderPath = null;
		try 
		{
			CreatedFolderPath = FolderPath+FolderName+"\\";
			File tmpDir = new File(CreatedFolderPath);
			boolean exists = tmpDir.exists();
			if (exists != true) 
			{
				File f2 = new File(CreatedFolderPath);
				f2.mkdir();
				if(tmpDir.exists()==true)
				{
					System.out.println("Folder is sucessfully created.");
				}
				else
				{
					System.out.println("Folder is not created.");
				}
			} 
			else if (exists == true) 
			{
				System.out.println("Folder is already is exists.");
			}
			File f1 = new File(CreatedFolderPath);
			f1.listFiles();
		}
		catch (Exception e) 
		{
			System.err.println("Unable to create folder!!!!!!!!!!!!!");
			System.err.println("Got Exception!!!!!!!!!!!");
			e.printStackTrace();
		}
		
		return CreatedFolderPath;
	}
	
	

}
