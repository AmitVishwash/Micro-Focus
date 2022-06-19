package com.ebay.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
               features = "src/test/resources/features/Registration.feature",
               glue="com.ebay.stepdef",
               tags = "@signin",
               monochrome = true,
               stepNotifications = true,
               plugin = {"pretty","json:target/cucumber.json","html:target/cucumber.html"}
)
public class Runner {
}
