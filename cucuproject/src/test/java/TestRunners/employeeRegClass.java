package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features ="featurefiles/emploeelogin.feature", glue = "stepDefinitions", dryRun = false, 
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:reports/addempresult.html"} ) public class employeeRegClass extends AbstractTestNGCucumberTests 
	
{
}
