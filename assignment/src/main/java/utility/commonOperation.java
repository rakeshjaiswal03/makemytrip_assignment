package utility;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonOperation {
	public WebDriver driver;
	public commonMethods cm; 

	public commonOperation(WebDriver driver, commonMethods cm) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.cm=cm;

	}
	
	@FindBy(how = How.XPATH, using = "//*[@class='datePickerContainer']//*[@class='DayPicker-Months']/div[1]//*[@class='DayPicker-Day']")
	public List<WebElement> dayspicker_List;
	@FindBy(how = How.XPATH, using = "//*[@class='datePickerContainer']//*[@class='DayPicker-NavBar']/span[1]")
	public WebElement cal_leftKey;
	@FindBy(how = How.XPATH, using = "//*[@class='datePickerContainer']//*[@class='DayPicker-NavBar']/span[2]")
	public WebElement cal_rightKey;
	
	String[] months = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
	
	public void SelectDate(WebElement element, String date) throws Exception  {
		 Thread.sleep(2000);
//		 element.click();
		String[] splitDate = date.split(" ");
		String dd = splitDate[0];
		String mm = splitDate[1];
		String yy = splitDate[2];
		checkMonth(mm);
		checkdatte2(dayspicker_List, dd);
	}
	public void SelectDate2(WebElement element, String date) throws Exception  {
		 Thread.sleep(2000); 
		String[] splitDate = date.split(" ");
		String dd = splitDate[0];
		String mm = splitDate[1];
		String yy = splitDate[2];
//		checkMonth(mm);
		checkdatte2(dayspicker_List, dd);
	}
	
	public void checkyear(int entY, int capY) throws InterruptedException {
		if(entY>capY) {
			for(int i=capY; i<entY+1; i++) {
				Thread.sleep(500);
				cal_rightKey.click();
				System.out.println("Clickon on Right icon");
				capY++;
				checkyear( entY,  capY);
			}
		}
		if(entY<capY) {
			for(int i=entY; i<capY;i++ ) {
				Thread.sleep(500);
				cal_leftKey.click();
				System.out.println("Clickon on left icon");
				entY++;
				checkyear( entY,  capY);
			}
		}		
	}
	
	public void checkMonth(String givenmonth) throws Exception {
		int gm = Integer.parseInt(givenmonth); 
		String date = cm.SpecificDate("dd MM yyyy", 0); 
		String[] splitDate = date.split(" ");
		String presentMonth = splitDate[1];
		int pm = Integer.parseInt(presentMonth); 
		System.out.println("gm:pm=="+gm+":"+pm); 	Thread.sleep(2000);
		if(gm<pm) {
			Thread.sleep(2000);
			cal_leftKey.click();
		}

		if(gm>pm) {
			Thread.sleep(2000);
			cal_rightKey.click();
		}
	}
	
	public void checkdatte(List<WebElement> element, String date) throws InterruptedException {
		int DaysSize = element.size();  							System.out.println("DaysSize:"+DaysSize);	
		for(int i=0; i<DaysSize-1; i++) {
			Thread.sleep(2000);
			  String celltext = element.get(i).getText();			System.out.println("celltext:"+celltext);
			  int intcelltext1 =Integer.parseInt(celltext);  
			  int intdate =Integer.parseInt(date);					System.out.println("intdate:"+intdate); 
			  
			  boolean ch1 = celltext.equalsIgnoreCase(date); boolean ch2 = intcelltext1==intdate;  
			  if(ch1==true || ch2==true) {
				  element.get(i).click();
//				  element.get(i).click(); // double click is imp
				  break; 
			  }
		}
	}
	
	public void checkdatte2(List<WebElement> element, String date) throws InterruptedException {
		int DaysSize = element.size();  System.out.println("DaysSize:"+DaysSize);
		for(int i=0; i<DaysSize-1; i++) {
			  String celltext = element.get(i).getText();
			  int intcelltext =Integer.parseInt(celltext);  System.out.println("intcelltext:"+intcelltext); 
			  int intdate =Integer.parseInt(date); 			System.out.println("intdate:"+intdate); 
			  boolean check= intcelltext== intdate; 		System.out.println("check:"+check);
			  if(intcelltext== intdate ) {
				  element.get(i).click();
				  break; 
			  }
		}
	}
	
	public void ImplicitlyWait(WebDriver driver, int waitTimeInSec)
	{
		driver.manage().timeouts().implicitlyWait(waitTimeInSec, TimeUnit.SECONDS);	
	}

	public void VisibilityOfElementExplicityWait(WebDriver driver, WebElement element, int timeInSec)
	{
		try
        {
			WebDriverWait wait = new WebDriverWait(driver, timeInSec);
			wait.until(ExpectedConditions.visibilityOf(element));
        }
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	public  Boolean isElementPresent(WebDriver driver, WebElement Element)
    {
		boolean isFound = false;
        try
        {
            isFound = Element.isDisplayed();
        }
        catch (Exception ex)
        {
            isFound = false;
        	System.out.println(ex.toString());
        }
        
        return isFound;
    }
	
	 //Get The Current Day plus days. You can change this method based on your needs.
    public  String getCurrentDayPlus(int days) {
        LocalDate currentDate = LocalDate.now();
        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue(); 
        return Integer.toString(dayOfWeekPlus);
    }
    //Click to given day
    public  void clickGivenDay(List<WebElement> elementList, String day) {
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        /**Functional JAVA version of this method.*/
        elementList.stream()
            .filter(element -> element.getText().contains(day))
            .findFirst()
            .ifPresent(WebElement::click);
    }
	

}
