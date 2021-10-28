package com.tests;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
     features = {"src/specs/features"},
     //glue = {""},
     plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Orange.html"},
     tags = {("@search")},
     snippets = SnippetType.CAMELCASE,
     monochrome = true
     )

public class TestRunner {

	 @AfterClass
	 public static void writeExtendReport() {
		 Reporter.loadXMLConfig(new File("src/test/resources/configs/extent-config.xml"));
}
	 
}

