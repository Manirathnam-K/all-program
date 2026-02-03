package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\com.feature",
glue = "com.stepdefinition",
monochrome = true,
dryRun = false,
publish = true,
plugin = {"html:Reports/Naukri.html",
		"json:Reports/Naukri.json",
		"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class NaukriRunner {

}
