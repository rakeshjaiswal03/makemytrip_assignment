package utility;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverMethods {
	

	WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    String alertMessage;
    String parentWindowHandler = null; 
    
	public webdriverMethods(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public void ImplicitlyWait(WebDriver driver, int waitTimeInSec)
	{
		driver.manage().timeouts().implicitlyWait(waitTimeInSec, TimeUnit.SECONDS);	
	}
	public void refreshWebsite() throws InterruptedException
	{
		driver.navigate().refresh(); Thread.sleep(5000);
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
	public String getWindowhandle(){
		  return driver.getWindowHandle(); 
	}
	
	public String[] getAll_WindowHandles()
	{
		  Set<String> set =driver.getWindowHandles();
		  Iterator<String> itr= set.iterator();
		  String[] win=new String[5];
		  int i=0;
		  while (itr.hasNext()) 
		  {
			win[i]=itr.next();
			i++;
		  }
		  return win;
	}
	public void switchtochildwindow(String childwindow) {
		driver.switchTo().window(childwindow);
		System.out.println(driver.switchTo().window(childwindow).getTitle());	
	}
	public void switchToParentBrowserTab(String mainwindow) {
	      driver.switchTo().window(mainwindow);
	}
	public  Boolean isElementPresent( WebElement Element) throws InterruptedException
    {	Thread.sleep(2000);
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
        System.out.println(":::isElementPresent:::"+isFound);
        return isFound;
    }
	public  Boolean isElementAttributeValueContain(WebDriver driver, WebElement element,String attributeName, String attributeValue)
    {
		boolean isEqual = false;
        try
        {
            isEqual = element.getAttribute(attributeName).contains(attributeValue);
        }
        catch (Exception ex)
        {
        	isEqual = false;
        	System.out.println(ex.toString());
        }
        System.out.println("isElementAttributeValueContain:::"+isEqual);
        return isEqual;
    }
	public  Boolean isElementTextContain(WebDriver driver, WebElement Element, String ElementText)
    {
		System.out.println("Element.getText()::"+Element.getText());
		boolean isMatch = false;
        try
        {
            isMatch = Element.getText().contains(ElementText);
        }
        catch (Exception ex)
        {
        	isMatch = false;
        	System.out.println(ex.toString());
        }
        
        return isMatch;
    }
	
	public void ClearTextbox(WebDriver driver, WebElement element) throws Throwable
	{
		 Actions move = new Actions(driver);
		 Action clear = move.moveToElement(element).build();
		 clear.perform();
		 Thread.sleep(2000);
		 clear = move.click().build();
		 clear.perform();
		 Thread.sleep(2000);
		 clear = move.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE).build();
		 clear.perform();
		 Thread.sleep(3000);
//		 ImplicitlyWait(driver, 5);
	}
	
	public void ExplicityWaitForElementTobeClickable(WebDriver driver, WebElement element, int timeInSec)
	{
		try
        {
			WebDriverWait wait = new WebDriverWait(driver, timeInSec);
			wait.until(ExpectedConditions.elementToBeClickable(element));
        }
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	public void SelectFromDropdownList(WebDriver driver, WebElement elementToClick, List <WebElement> DropdownListElements, String selectValue) throws Throwable
	{
		ExplicityWaitForElementTobeClickable(driver, elementToClick, 10);
		elementToClick.click();
		Thread.sleep(1000);
		ImplicitlyWait(driver, 5);
		for (int i = 0; i < DropdownListElements.size(); i++) 
		{
			if (isElementTextContain(driver, DropdownListElements.get(i), selectValue) == true)
			{
				DropdownListElements.get(i).click();
				break;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
	}
	
	public void SelectFromAutoDropdownList(WebDriver driver, WebElement elementToClick, List <WebElement> DropdownListElements, String selectValue) throws Throwable
	{
		elementToClick.sendKeys(selectValue);
		Thread.sleep(3000);
//		ImplicitlyWait(driver, 6);
		for (int i = 0; i < DropdownListElements.size(); i++) 
		{
			if (isElementTextContain(driver, DropdownListElements.get(i), selectValue) == true)
			{
//				Actions move = new Actions(driver);
//			    Action click = move.moveToElement(DropdownListElements.get(i)).click().sendKeys(Keys.BACK_SPACE).build();
//			    click.perform();
				DropdownListElements.get(i).click();
				break;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
	}
	
	
	
	public void SelectFromCheckDropdownList(WebDriver driver, WebElement elementToClick, WebElement searchFieldElement, 
			List <WebElement> DropdownNameListElements, List <WebElement> DropdownNameCheckElements,String selectValue) throws Throwable
	{
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		searchFieldElement.sendKeys(selectValue);
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		for (int i = 0; i < DropdownNameListElements.size(); i++)
		{
			if (isElementTextContain(driver, DropdownNameListElements.get(i), selectValue) == true)
			{
				DropdownNameCheckElements.get(i).click();
				break;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
	}
	
	public void SelectFromCheckDropdownList(WebDriver driver, WebElement elementToClick, WebElement searchFieldElement, 
			List <WebElement> DropdownNameListElements, List <WebElement> DropdownNameCheckElements, String[] selectValues) throws Throwable
	{
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		for (int i = 0; i < selectValues.length; i++) 
		{
			searchFieldElement.clear();
//			Thread.sleep(500);
			ImplicitlyWait(driver, 5);
			ClearTextbox(driver, searchFieldElement);
//			Thread.sleep(500);
			ImplicitlyWait(driver, 5);
			searchFieldElement.sendKeys(selectValues[i]);
//			Thread.sleep(2000);
			ImplicitlyWait(driver, 5);
			for (int j = 0; j < DropdownNameListElements.size(); j++)
			{
				if (isElementTextContain(driver, DropdownNameListElements.get(j), selectValues[i]) == true)
				{
					DropdownNameCheckElements.get(j).click();
					break;
				}
			}
//			Thread.sleep(2000);
			ImplicitlyWait(driver, 5);
		}
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
	}
	
	public void DragAndDrop(WebDriver driver, WebElement fromElement, WebElement toElement) throws Throwable
	{
		 Actions moved = new Actions(driver);
		 Action dragDrop = moved.moveToElement(fromElement)
				 .clickAndHold(fromElement)
				 .moveToElement(toElement)
				 .release(toElement).build();
		 dragDrop.perform();
		 
		 Thread.sleep(3000);
	}
	public void DragAndDrop(WebDriver driver, List <WebElement> ColHeaderNameList, WebElement DropLocation, String colName) throws Throwable
	 {
		 for (int i = 0; i < ColHeaderNameList.size(); i++) 
		 {
			 if(isElementTextContain(driver, ColHeaderNameList.get(i), colName))
			 {
				 DragAndDrop(driver, ColHeaderNameList.get(i), DropLocation);
				 break;
			 }
		 }
		 ImplicitlyWait(driver, 5);
//		 Thread.sleep(1000);
	 }

	public void Action_ScrollSide(WebDriver driver, WebElement element)
	{
		Actions move = new Actions(driver);
	    Action scroll = move.moveToElement(element).click().sendKeys(Keys.ARROW_RIGHT).build();
	    scroll.perform();
	    ImplicitlyWait(driver, 10);
	}
	
	public void Action_ScrollDown(WebDriver driver, WebElement element)
	{
		Actions move = new Actions(driver);
	    Action scroll = move.moveToElement(element).click().sendKeys(Keys.ARROW_DOWN).build();
	    scroll.perform();
	    ImplicitlyWait(driver, 10);
	}
	
	public void Action_MoveOverElement(WebDriver driver, WebElement element)
	{
		Actions move = new Actions(driver);
	    Action hover = move.moveToElement(element).build();
	    hover.perform();
	    ImplicitlyWait(driver, 10);
	}
	
	public void Action_SelectElement(WebDriver driver) throws Throwable
	{
		Actions select = new Actions(driver);
		select.sendKeys(Keys.chord(Keys.CONTROL,Keys.SPACE)).build().perform();
		Thread.sleep(500);
		select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
	}
	
	public void Action_SelectElement(WebDriver driver, WebElement element) throws Throwable
	{
		Actions select = new Actions(driver);
		select.moveToElement(element).build().perform();
		Thread.sleep(500);
		select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
	}

	public void  scrolldown(WebDriver driver, WebElement element) throws InterruptedException {
		Actions actions = new Actions(driver); 
		Actions scrollDown = actions.moveToElement( element ); 
		scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform(); 
		Thread.sleep( 1000  );
	}
	



}
