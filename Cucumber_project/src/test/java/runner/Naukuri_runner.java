package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/com.feature/naukri.feature",
    glue = "Stepdefinition",
    plugin = {"pretty", "html:target/Naukuri_report.html"},
    monochrome = true,
    dryRun = false
)
public class Naukuri_runner extends AbstractTestNGCucumberTests {

}