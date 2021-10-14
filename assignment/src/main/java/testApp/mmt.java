package testApp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class mmt {
	public WebDriver driver;

	public mmt(WebDriver driver) 	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(how = How.XPATH, using = "//*[@class='userSection pushRight']//li")
	public List<WebElement> section;
	@FindBy(how = How.XPATH, using = "//*[@class='userSection pushRight']//li[3]/div[1]")
	public WebElement loginBtn;
	@FindBy(how = How.XPATH, using = "//div[@id='root']//*[@class='minContainer']")
	public WebElement flighspage;

	@FindBy(how = How.XPATH, using = "//*[@class='menu_Hotels']//a") //div[@id='root']//*[@class='headerOuter']//*[@class='chHeaderContainer']//nav//li[2]/a	
	public WebElement Hotels_menuBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='root']//*[@class='hsw_inner']//*[@id='hsw_inputBox_city']//input")
	public WebElement city_field;
	@FindBy(how = How.XPATH, using = "//*[@class='hsw_autocomplePopup locus']//input")
	public WebElement city_searchfield;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'London, United Kingdom')]")
	public WebElement londonXpath;
	@FindBy(how = How.XPATH, using = "//div[@id='react-autowhatever-1']//div/ul/li")
	public List<WebElement> Autosuggested_from_List;
	@FindBy(how = How.XPATH, using = "//*[@class='primaryBtn font24 latoBold widgetSearchBtn ']")
	public WebElement FlightPage_searchBtn;
	@FindBy(how = How.XPATH, using = "//button[@id='hsw_search_button']")
	public WebElement HotelsPage_searchBtn;
	 
	@FindBy(how = How.XPATH, using = "//*[@id='hsw_inputBox_check_in']//input[@id='checkin']")
	public WebElement checkIn_field;
	@FindBy(how = How.XPATH, using = "//*[@id='hsw_inputBox_check_out']//input[@id='checkout']")
	public WebElement checkOut_field;
	 
	
	@FindBy(how = How.XPATH, using = "//*[@class='roomsGuests']//button[2]")
	public WebElement Apply_Button;
	@FindBy(how = How.XPATH, using = "//*[@id='_Hlisting_header']//button")
	public WebElement hotelPage_SearchButton;
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='hotelListingContainer']//*[@class='listingRowOuter hotelTileDt makeRelative']//a")
	public List<WebElement> suggestedHotels_List;

	@FindBy(how = How.XPATH, using = "//*[@id='hlistpg_hotel_shown_price']")
	public List<WebElement> suggestedHotels_priceList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='hlistpg_sortby_option']//span")
	public WebElement sortby;
	@FindBy(how = How.XPATH, using = "//*[@id='hlistpg_sortby_option']//ul/li")
	public List<WebElement> sortbyOptions;
	
	
	
	

}
