package Stepdefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testApp.mmt;
import utility.commonMethods;
import utility.commonOperation;
import utility.setup;
import utility.webdriverMethods;
import static utility.constant.*; 
public class test_makemytrip {
	public WebDriver driver; 
	public setup launch;
	public commonMethods cm;
	public commonOperation co; 
	public mmt mmt__; 
	public webdriverMethods wm; 
	String ConfigKeysFile = "config.properties";
	String  URL = null; 
	Boolean verify = false; 
	Integer hotel1 =  null, hotel2 = null; 

	@Given("launch browser and launch MakeMyTrip website")
	public void launch_browser_and_launch_make_my_trip_website() throws IOException, InterruptedException {
		File file = new File(ConfigKeysFile);
		InputStream fis = new FileInputStream(file);
		Properties pf = new Properties();
		pf.load(fis);

		URL = pf.getProperty("MMT");
		launch = new setup(); 
//		launch.LaunchFirefox(firefoxDriverPath, URL); 
		driver = launch.LaunchChrome(ChromeDriverPath, URL); 
		
		cm = new commonMethods(); 
		co = new commonOperation(driver, cm);
		wm = new webdriverMethods(driver);
		mmt__ = new mmt(driver); 
		 
		Thread.sleep(5000);
	}
	@Given("validate MMT Home page is displayed")
	public void validate_mmt_home_page_is_displayed() throws InterruptedException {
		co.VisibilityOfElementExplicityWait(driver,mmt__.FlightPage_searchBtn  , 20); Thread.sleep(5000);
		verify = wm.isElementPresent( mmt__.FlightPage_searchBtn); 
		
	}
	@And("navigate to Hotels screen")
	public void navigate_to_Hotels_screen() throws InterruptedException {
		launch.navigateTo("https://www.makemytrip.com/hotels/hotel-listing/?checkin=10142021&city=CTGOI&checkout=10152021&roomStayQualifier=2e0e&locusId=CTGOI&country=IN&locusType=city&searchText=Goa,%20India&visitorId=6ccaa7ed-cc0e-4f0a-95c5-b73b42513a8f&regionNearByExp=3");
//	    wm.refreshWebsite();
//	    wm.refreshWebsite();
//		Thread.sleep(5000);    
	}

//	@Given("click on Hotels menu")
//	public void click_on_hotels_menu() throws InterruptedException {
//	
////		co.VisibilityOfElementExplicityWait(driver,mmt__.Hotels_menuBtn  , 20); Thread.sleep(5000);
////		verify = wm.isElementPresent(driver, mmt__.Hotels_menuBtn); 
////	    cm.Verify(verify, true); Thread.sleep(5000);
//	    wm.refreshWebsite();
//	    wm.refreshWebsite();
////		mmt__.loginBtn.click();
//		Thread.sleep(5000);
//		mmt__.Hotels_menuBtn.click();
//		
//	     
//	}
	@When("Search location {string}")
	public void search_location(String string) throws InterruptedException {
		co.VisibilityOfElementExplicityWait(driver,mmt__.city_field  , 20); Thread.sleep(5000);
		verify = wm.isElementPresent( mmt__.city_field); 
	    cm.Verify(verify, true); Thread.sleep(5000);
	    mmt__.city_field.click(); Thread.sleep(2000); System.out.println(string);
	    
	    co.VisibilityOfElementExplicityWait(driver,mmt__.city_searchfield  , 20); Thread.sleep(5000);
		verify = wm.isElementPresent( mmt__.city_searchfield); 
	    cm.Verify(verify, true); Thread.sleep(5000);
		mmt__.city_searchfield.sendKeys(string);  Thread.sleep(2000);
		mmt__.Autosuggested_from_List.get(0).click();
	}
	@When("From date should be {int} days from today")
	public void from_date_should_be_days_from_today(Integer int1) throws Exception {
		String date = cm.SpecificDate("d MM yyyy", int1); 
	   co.SelectDate(mmt__.checkIn_field, date);
		
	}
	@When("To date should be {int} days from today")
	public void to_date_should_be_days_from_today(Integer int1) throws Exception {
		String date = cm.SpecificDate("d MM yyyy", int1); 
		   co.SelectDate2(mmt__.checkOut_field, date);
	     
	}
	@When("Search result")
	public void search_result() throws InterruptedException {
		Thread.sleep(1000);mmt__.Apply_Button.click(); 
		Thread.sleep(2000);mmt__.hotelPage_SearchButton.click();
	     
	}
	@When("Capture the count of results")
	public void capture_the_count_of_results() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("without scrolling suggested hotels size:::"+    mmt__.suggestedHotels_List.size());

	}
	@Then("observer top two hotels and capture the rate")
	public void observer_top_two_hotels_and_capture_the_rate() throws InterruptedException {
		Thread.sleep(1000);mmt__.sortby.click();
		Thread.sleep(1000);mmt__.sortbyOptions.get(2).click(); Thread.sleep(3000);
		
		co.VisibilityOfElementExplicityWait(driver,mmt__.suggestedHotels_priceList.get(0)  , 20); Thread.sleep(10000);
		verify = wm.isElementPresent( mmt__.suggestedHotels_priceList.get(0)); 
	    cm.Verify(verify, true); Thread.sleep(5000);
	    
	    hotel1 = Integer.parseInt(mmt__.suggestedHotels_priceList.get(0).getText());
	    hotel2 = Integer.parseInt(mmt__.suggestedHotels_priceList.get(1).getText());
	    System.out.println("First Hotel's price:::"+ hotel1);
	    System.out.println("Second Hotel's price:::"+ hotel2);
	}
	@When("Open the detail page of first and second suggessted Hotel")
	public void open_the_detail_page_of_first_and_second_suggessted_hotel() {
	   String main_window = wm.getWindowhandle(); System.out.println("main_window::::"+ main_window);
	   mmt__.suggestedHotels_List.get(0).click();
	   String []childwindow1 = wm.getAll_WindowHandles();   
	   System.out.println(childwindow1.toString());
	   wm.switchtochildwindow(childwindow1.toString());
	   wm.switchToParentBrowserTab(main_window);
	   mmt__.suggestedHotels_List.get(1).click();
	   String []childwindow2 = wm.getAll_WindowHandles();   
	   System.out.println(childwindow2.toString());
	   wm.switchtochildwindow(childwindow2.toString());
	   wm.switchToParentBrowserTab(main_window);
	}
	@Then("Open details page of both entries and capture rates")
	public void open_details_page_of_both_entries_and_capture_rates() {
	     
	     
	}
	@Then("campare rate and provide conclusion")
	public void campare_rate_and_provide_conclusion() {
	     if(hotel1<hotel2) {
	    	 System.out.println("hotel1  <<<< hotel2");
	     }
	     if(hotel1>hotel2) {
	    	 System.out.println("hotel1 >>> hotel2");
	     }
	     if(hotel1==hotel2) {
	    	 System.out.println("hotel1  ==== hotel2");
	     }
	     
	}

	

}
