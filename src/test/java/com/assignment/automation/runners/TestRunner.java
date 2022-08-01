package com.assignment.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:features",
		glue="com.assignment.automation.stepdefs",
		tags="@SignInPgTitleValidationTest",
		plugin = {"pretty",
				"html:target/html/htmlReport.html",
				"json:target/json/jsonReport.json"
		},
		monochrome = true,
		publish = true,
		dryRun=false
		)

public class TestRunner {
	
}
