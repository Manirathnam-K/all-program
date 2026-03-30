package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Feature",
		glue = {"StepDefinition"},
		publish = true,
		monochrome = true,
		dryRun = false,
		 plugin = {"pretty","html:reports/cucumber-report.html",
					"json:reports/cucumber-report.json",
					"junit:reports/cucumber-report.xml",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)



public class TestRunner extends AbstractTestNGCucumberTests {

}
