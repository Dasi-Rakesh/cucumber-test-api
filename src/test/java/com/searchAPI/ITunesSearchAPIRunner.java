package com.searchAPI;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/iTunesSearchAPI.feature",
        glue = "com.searchAPI"
)
public class ITunesSearchAPIRunner extends AbstractTestNGCucumberTests {
}
