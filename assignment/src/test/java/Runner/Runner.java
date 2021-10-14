package Runner;
/////Assiggment project 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
				 "pretty" , 				
		}, 

		features = "features", 
		tags ="@mmt1",
		glue = "Stepdefination", monochrome = true)

public class Runner {


}
