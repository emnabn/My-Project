package com.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
     features = {"src/specs/features"},
     //glue = {""},
     plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Orange.html"},
     tags = {("@cx")},
     snippets = SnippetType.CAMELCASE,
     monochrome = true
     )

public class TestRunner {

}

