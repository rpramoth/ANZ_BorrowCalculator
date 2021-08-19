package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "/Users/Pramod/Desktop/New folder/com.Collabera/src/main/java/Feature/BorrowCalc.feature", 
			glue={"stepDefn"}, //the path of the step definition files
			format= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
			monochrome = true, //display the console output in a proper readable format
			strict = false, 
			dryRun = false 
			)
	 
	public class TestRunner {
	 
		
	}